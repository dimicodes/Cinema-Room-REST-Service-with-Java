package cinema.utilities;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    private final int rows = 9;
    private final int columns = 9;
    private List<Seat> seats;

    public CinemaRoom() {
        seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    // Getters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

