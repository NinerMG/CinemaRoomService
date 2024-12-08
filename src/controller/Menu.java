package controller;

import model.Income;
import model.Seats;
import service.statistics.CinemaStatistics;
import view.UserInput;

public class Menu {
    private CinemaController controller;
    private Income income;
    private Seats seats;
    private CinemaStatistics statistics;

    public Menu(CinemaController controller, Income income, Seats seats, CinemaStatistics statistics){
        this.controller = controller;
        this.income = income;
        this.seats = seats;
        this.statistics = statistics;
    }

    public void showMenu(){
        boolean isRunning = true;

        while(isRunning){
            displayMenuOptions();
            int choice = getUserChoice();
            isRunning = processMenuChoice(choice);
        }
    }

    private void displayMenuOptions(){
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Show statistics");
        System.out.println("0. Exit");
    }
    private int getUserChoice(){
        UserInput userInput = new UserInput();
        return userInput.getNumber("");
    }

    private boolean processMenuChoice(int choice){
        switch (choice){

            case 1:
                controller.drawCinema(seats);
                break;
            case 2:
                controller.chooseSeat();
                break;
            case 3:
                statistics.printStatistics();
                break;
            case 0:
                System.out.println("See you later!");
                return false;
            default:
                System.out.println("Wrong number! Please try again");
        }
        return true;
    }
}
