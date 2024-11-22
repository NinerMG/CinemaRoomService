package service.calculators;

import service.IncomeCalculator;

public class LargeCinemaIncomeCalculator implements IncomeCalculator {
    private int rows;
    private int col;

    public LargeCinemaIncomeCalculator(int rows, int col){
        this.rows = rows;
        this.col = col;
    }

    @Override
    public int calculateIncome() {
       int frontHalf = rows /2;
       int backHalf = rows - frontHalf;

       return (frontHalf * col * 10 + backHalf * col * 8);
    }

    @Override
    public int getTicketPrice(int row) {
        int frontHalf = row /2;
        return row < frontHalf ? 10 : 8;
    }

}
