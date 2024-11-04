package service.calculators.factory;

import service.IncomeCalculator;
import service.calculators.LargeCinemaIncomeCalculator;
import service.calculators.SmallCinemaIncomeCalculator;

public class IncomeCalculatorFactory {
    private final int MAX_SMALL_CINEMA_SEATS = 60;

    public IncomeCalculator createCalculator(int row, int col){
        if (row <= 0 || col <= 0) {
            throw new IllegalArgumentException("These arguments should be positive and greater than zero");
        }

        int seats = row * col;

        if (seats <= MAX_SMALL_CINEMA_SEATS){
            return new SmallCinemaIncomeCalculator(seats);
        } else {
            return new LargeCinemaIncomeCalculator(row, col);
        }
    }
}
