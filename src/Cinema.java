public class Cinema {

    public Cinema(){

        UserInput userInput = new UserInput();
        Seats seats = new Seats(userInput.seats, userInput.rows);
         }
}
