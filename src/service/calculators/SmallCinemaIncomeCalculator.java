package service.calculators;

import service.IncomeCalculator;

public class SmallCinemaIncomeCalculator implements IncomeCalculator {
    private int seats;

    public SmallCinemaIncomeCalculator(int seats){
        this.seats = seats;
    }

    @Override
    public int calculateIncome() {
        return seats * 10;
    }

    @Override
    public int getTicketPrice(int row){
        return 10;
    }
}
