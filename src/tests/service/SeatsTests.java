package tests.service;

import model.Seats;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SeatsTests {

    @Test
   public void shouldFillCinemaWithAvailableSeats() {
        Seats seats = new Seats(5, 5);
        char[][] seatArrangement = seats.getSeats();
        for (char[] row : seatArrangement) {
            for (char seat : row) {
                assertEquals('S', seat, "Expected seat to be marked as 'S'");
            }
        }
    }

    @Test
    public void shouldReturnFalseIfSeatIsNotOccupied() {
        Seats seats = new Seats(5, 5);
        assertFalse(seats.isSeatOccupied(0, 0), "Expected seat to be unoccupied initially.");
    }
}
