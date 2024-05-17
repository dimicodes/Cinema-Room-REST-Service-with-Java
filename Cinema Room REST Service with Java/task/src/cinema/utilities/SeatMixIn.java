package cinema.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SeatMixIn {
    @JsonIgnore
    boolean isAvailable();  // Ignoring the isAvailable field
}