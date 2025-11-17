package ex1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bus bus = new Bus();

        for (int i = 0; i < 4; i++) {
            Passenger passenger = new Passenger("P-"+i,bus);
            passenger.start();
        }

    }
}
