package model;

import java.util.Arrays;

public class Seats {

    private int rows;
    private int col;
    private char[][] seats;

    public Seats(int rowsNumber, int columnNumber){
        this.rows = rowsNumber;
        this.col = columnNumber;
        fillCinema();
    }

    public void setRows(int rows){
        this.rows = rows;
    }
    public void setCol(int col){
        this.col = col;
    }

    public char[][] getSeats() {
        return seats;
    }

    public int getRows() {
        return rows;
    }

    public int getCol() {
        return col;
    }

    public void fillCinema(){
        seats = new char[rows][col];
        for (int i = 0; i < rows; i++){
            Arrays.fill(seats[i], 'S');
        }
    }
    public boolean isSeatOccupied(int row, int col){
        return seats[row][col] == 'B';
    }
}
