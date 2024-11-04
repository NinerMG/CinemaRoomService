package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    public int getNumber(String message){
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
}
