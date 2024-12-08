package controller;

import model.Income;
import model.Seats;
import service.inputCalculator.InputCalculator;
import service.statistics.CinemaStatistics;
import view.DrawCinema;
import view.UserInput;

public class CinemaController {
    private Seats seats;
    private InputCalculator inputCalculator;
    private Income income;
    private final UserInput userInput = new UserInput();
    private CinemaStatistics statistics;

    public void start() {
        income = new Income(0);
        seats = setupSeats();
        inputCalculator = new InputCalculator(seats.getRows(), seats.getCol());
        statistics = new CinemaStatistics(seats, income);

         Menu menu = new Menu(this, income, seats, statistics);
         menu.showMenu();
    }
    private Seats setupSeats() {
        int numberOfRows = userInput.getNumber("Enter the number of rows:");
        int numberOfSeats = userInput.getNumber("Enter the number of seats in each row:");
        return new Seats(numberOfRows, numberOfSeats);
    }
    public void drawCinema(Seats seats) {
        DrawCinema drawCinema = new DrawCinema(seats);
        drawCinema.drawCinema();
    }

    public void chooseSeat(){
        int numberOfRow = userInput.getNumber("Enter a row number:");
        int numberOfSeat = userInput.getNumber("Enter a seat number in that row:");
        System.out.println();
        if (!isSeatValidAndAvailabe(numberOfRow, numberOfSeat)){
            chooseSeat();
        }else {
            int price = inputCalculator.getTicketPrice(numberOfRow);
            System.out.println("Ticket price: $" + price);
            income.updateTotalIncome(price);
            seats.bookSeat(numberOfRow - 1, numberOfSeat - 1);
        }
    }

    private boolean isSeatValidAndAvailabe(int row, int col){
        if (row <= 0 || col <= 0) {
            System.out.println("Error: Row and column numbers must be greater than 0.");
            return false;
        }

        if(!seats.isSeatValid(row, col)){
            System.out.println("Error: The seat number is out of cinema bounds. Please enter a valid seat.");
            return false;
        }
        if (seats.isSeatOccupied(row -1, col-1)){
            System.out.println("Error: The seat is already occupied. Please choose a different seat");
            return false;
        }
        return true;
    }
}
