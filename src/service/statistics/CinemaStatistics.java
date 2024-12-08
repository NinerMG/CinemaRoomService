package service.statistics;

import controller.CinemaController;
import model.Income;
import model.Seats;
import service.inputCalculator.InputCalculator;

public class CinemaStatistics {
    private Seats seats;
    private Income income;

    public CinemaStatistics(Seats seats, Income income){
        this.seats = seats;
        this.income = income;
    }

    public void printStatistics(){
        System.out.println("Number of purchased tickets: " + getNumberOfOPurchasedTickets());
        System.out.printf("Percentage: %.2f%%%n", getPercentage());
        System.out.println("Current income: $" + getCurrentIncome());
        System.out.println("Total income: $" + getTotalIncome());
    }

    private int getNumberOfOPurchasedTickets(){
        int purchasedTickets = 0;
        char[][] seatTemplate = seats.getSeats();
        for (char[] row : seatTemplate){
            for (char seat : row) {
                if (seat == 'B'){
                    purchasedTickets++;
                }
            }
        }
        return purchasedTickets;
    }

    private double getPercentage(){
        int tickets = getNumberOfOPurchasedTickets();
        int allSeats = seats.getCol() * seats.getCol();
        return (double) tickets/allSeats * 100;
    }

    private int getCurrentIncome(){
        return income.getTotalIncome();
    }

    private int getTotalIncome(){
        int rows = seats.getRows();
        int col = seats.getCol();

        return new InputCalculator(rows, col).getTicketPrice(1) * rows * col;
    }
}
