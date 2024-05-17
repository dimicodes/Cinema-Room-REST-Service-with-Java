package cinema.utilities;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CinemaRoomController {
    private final CinemaRoom cinemaRoom = new CinemaRoom();
    private static final String PASSWORD = "super_secret";

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return new CinemaRoom();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody Seat requestedSeat) {
        for (Seat seat : cinemaRoom.getSeats()) {
            if (seat.getRow() == requestedSeat.getRow() && seat.getColumn() == requestedSeat.getColumn()) {
                if (!seat.isAvailable()) {
                    return ResponseEntity.badRequest().body(Map.of("error", "The ticket has been already purchased!"));
                }
                seat.setAvailable(false); // Mark the seat as purchased
                seat.setToken(UUID.randomUUID().toString()); // Set a unique token
                return ResponseEntity.ok(Map.of(
                        "token", seat.getToken(),
                        "ticket", Map.of(
                                "row", seat.getRow(),
                                "column", seat.getColumn(),
                                "price", seat.getPrice()
                        )
                ));
            }
        }
        return ResponseEntity.badRequest().body(Map.of("error", "The number of a row or a column is out of bounds!"));
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        for (Seat seat : cinemaRoom.getSeats()) {
            if (token.equals(seat.getToken()) && !seat.isAvailable()) {
                seat.setAvailable(true); // Set the seat to be available again (returned)
                seat.setToken(null); // Clear the token
                return ResponseEntity.ok(Map.of(
                        "ticket", Map.of(
                                "row", seat.getRow(),
                                "column", seat.getColumn(),
                                "price", seat.getPrice()
                        )
                ));
            }
        }
        return ResponseEntity.badRequest().body(Map.of("error", "Wrong token!"));
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(value = "password", required = false) String password) {
        if (password == null || !PASSWORD.equals(password)) {
            return ResponseEntity.status(401).body(Map.of("error", "The password is wrong!"));
        }
        int totalIncome = 0;
        int purchasedTickets = 0;
        for (Seat seat : cinemaRoom.getSeats()) {
            if (!seat.isAvailable()) {
                totalIncome += seat.getPrice();
                purchasedTickets++;
            }
        }
        int availableTickets = cinemaRoom.getSeats().size() - purchasedTickets;
        return ResponseEntity.ok(Map.of(
                "income", totalIncome,
                "available", availableTickets,
                "purchased", purchasedTickets
        ));
    }
}
