public class CalculateIncome {
    private int rowsSeats;
    private int colSeats;

    public void setsSeats(int rows, int cols){
      rowsSeats = rows;
      colSeats = cols;
    }

    public int calculateIncomeSimple(){
        int seatsNumber = rowsSeats * colSeats;

        int income = incomeCalculate(seatsNumber);

        return income;
    }

    private int smallCinema(int seatsNumber){
        return seatsNumber * 10;
    }
    private int largeCinema(int seatsNumber){
      int fronHalf = rowsSeats /2;
      int backHalf = rowsSeats - fronHalf;

      int income = fronHalf * colSeats * 10 + backHalf * colSeats * 8;
      return income;
    }

    private int incomeCalculate(int seatsNumber){
        if (seatsNumber <= 60){
            return smallCinema(seatsNumber);
        } else {
            return largeCinema(seatsNumber);
        }
    }
}
