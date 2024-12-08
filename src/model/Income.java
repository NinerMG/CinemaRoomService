package model;

public class Income {

    private int totalIncome;

    public Income(int totalIncome){
        this.totalIncome = totalIncome;
    }

    public int getTotalIncome(){
        return totalIncome;
    }
    public void updateTotalIncome(int income){
        totalIncome += income;
    }
}
