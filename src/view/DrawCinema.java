package view;

import model.Seats;

public class DrawCinema {

    private Seats seats;

    public DrawCinema(Seats seats){
        this.seats = seats;
    }
    public void drawCinema() {
        drawHeadline();
        for (int i = 0; i < seats.getRows(); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats.getCol(); j++) {
                System.out.print(seats.getSeats()[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void drawHeadline() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats.getCol(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
