public class CinemaSeats {

    public CinemaSeats(){
        seatsDraw();
    }

    private void seatsDraw(){
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        String seats = "S S S S S S S S";
        for (int i = 1; i < 8; i++){
            System.out.println(i + " " + seats);
        }
    }
}
