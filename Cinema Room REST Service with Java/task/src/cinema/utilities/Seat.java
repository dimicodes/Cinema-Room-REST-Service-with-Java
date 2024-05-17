package cinema.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    @JsonIgnore // Ensures this field is not included in the JSON output
    private String token;
    private int row;
    private int column;
    private int price;
    @JsonIgnore // This annotation excludes the attribute from JSON serialization
    private boolean isAvailable;
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.isAvailable = true;
        this.price = row <= 4 ? 10 : 8; // Pricing logic based on row
    }

    // Getters and setters
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
