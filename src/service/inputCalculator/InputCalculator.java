package service.inputCalculator;

import service.IncomeCalculator;
import service.calculators.factory.IncomeCalculatorFactory;

public class InputCalculator {

    private int rows;
    private int seats;
    private IncomeCalculatorFactory factory = new IncomeCalculatorFactory();
    private IncomeCalculator calculator;

    public InputCalculator(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        calculator = factory.createCalculator(rows, seats);
    }

    public void printIncome() {
        System.out.println("Total income:");
        System.out.println("$" + calculator.calculateIncome());
    }
    public int getTicketPrice(int row){
        return calculator.getTicketPrice(row);
    }
}
