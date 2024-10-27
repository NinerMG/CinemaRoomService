import java.util.Arrays;

public class Seats {

    private int rows;
    private int col;
    private char[][] seats;

    public Seats(int rowsNumber, int columnsNumber){
        setCol(columnsNumber);
        setRows(rowsNumber);
        fillCinema();
        drawCinema();
    }

    public void setRows(int rows){
        this.rows = rows;
    }
    public void setCol(int col){
        this.col = col;
    }

    public int getRows(){
        return rows;
    }
    public int getCol(){
        return col;
    }

    private void fillCinema(){
        seats = new char[rows][col];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(seats[i], 'S');
        }
    }

    private void drawCinema(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

}