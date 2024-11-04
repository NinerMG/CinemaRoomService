package controller;

import model.Seats;
import service.inputCalculator.InputCalculator;
import view.DrawCinema;
import view.UserInput;

public class CinemaController {

    public void start() {
        Seats seats = setupSeats();
        drawCinema(seats);
        calculateAndPrintIncome(seats);
    }
    private Seats setupSeats() {
        UserInput userInput = new UserInput();
        int numberOfRows = userInput.getNumber("Enter the number of rows:");
        int numberOfSeats = userInput.getNumber("Enter the number of seats in each row:");
        return new Seats(numberOfRows, numberOfSeats);
    }
    private void drawCinema(Seats seats) {
        DrawCinema drawCinema = new DrawCinema(seats);
        drawCinema.drawCinema();
    }
    private void calculateAndPrintIncome(Seats seats) {
        InputCalculator inputCalculator = new InputCalculator(seats.getRows(), seats.getCol());
        inputCalculator.printIncome();
    }
}
