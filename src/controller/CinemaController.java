package controller;

import model.Seats;
import service.inputCalculator.InputCalculator;
import view.DrawCinema;
import view.UserInput;

public class CinemaController {
    private Seats seats;
    private InputCalculator inputCalculator;

    public void start() {
         seats = setupSeats();
         inputCalculator = new InputCalculator(seats.getRows(), seats.getCol());
        drawCinema(seats);
        //calculateAndPrintIncome(seats);
        chooseSeat();
        drawCinema(seats);
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

    private void chooseSeat(){
        UserInput userInput = new UserInput();
        int numberOfRow = userInput.getNumber("Enter a row number:");
        int numberOfSeat = userInput.getNumber("Enter a seat number in that row:");
        System.out.println();
        if (!isSeatValidAndAvailabe(numberOfRow, numberOfSeat)){
            chooseSeat();
        }else {

            int price = inputCalculator.getTicketPrice(numberOfRow);
            System.out.println("Ticket price: $" + price);
            seats.bookSeat(numberOfRow - 1, numberOfSeat - 1);
        }
    }

    private boolean isSeatValidAndAvailabe(int row, int col){
        if(!seats.isSeatValid(row, col)){
            System.out.println("Error: The seat number is out of cinema bounds. Please enter a valid seat.");
            return false;
        }
        if (seats.isSeatOccupied(row, col)){
            System.out.println("Error: The seat is already occupied. Please choose a different seat");
            return false;
        }
        return true;
    }



}
