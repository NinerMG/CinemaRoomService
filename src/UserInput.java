import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    CalculateIncome calculateIncome;
    int rows;
    int seats;
    public UserInput(){
        calculateIncome =  new CalculateIncome();
        setNumbers();
    }

    private int getNumber(String message){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(message);
            try {
                number =  scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("You should enter number!");
                scanner.nextLine();
            }
        }
        return number;
    }

    private void setNumbers(){
         rows = getNumber("Enter the number of rows:");
         seats = getNumber("Enter the number of seats in each row:");
         calculateIncome.setsSeats(rows, seats);
    }
    private void printIncome(){
        System.out.println("Total income:");
        System.out.println("$" + calculateIncome.calculateIncomeSimple());
    }
}
