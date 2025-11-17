package ex1;

import wait_notify.Main;

public class Passenger extends Thread{
    private final String name;
    private final Bus bus;
    private final int AMOUNT_TICKET = 1;

    public Passenger(String name, Bus bus) {
        this.name = name;
        this.bus = bus;
    }

    @Override
    public void run() {
        System.out.println("=========Passenger " + name + " started=======");

        /*if (bus.getAmountSeatBus() == bus.getAMOUNT_MAX()) {
            System.out.println("Bus empty.   " + name + "get on Bus");
            bus.getOnPass(AMOUNT_TICKER);
        }*/

       /* while (true){
            int numberRandom = (int)(Math.random()*100);
            System.out.println("Number random: " + numberRandom);

            if (numberRandom % 2 == 0){
                System.out.println("Passenger " + name + "get on Bus");
                bus.getOnPass(AMOUNT_TICKER);

            } else {
                System.out.println("Passenger " + name + "get off Bus");
                bus.getOffPass(AMOUNT_TICKER);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " sleep interrupted.");
                return;
            }
        }*/


        while (true) {
            // Simulate a travel
            System.out.println(name + " Treat get on Bus");
            bus.getOnPass(AMOUNT_TICKET);

            try {
                System.out.println(name + " inside bus. Traveling...");
                Thread.sleep(4000 + (int)(Math.random() * 3000));
            } catch (InterruptedException e) {
                return;
            }

            // Simulate to Down
            System.out.println(name + " Treat get of bus...");
            bus.getOnPass(AMOUNT_TICKET);
            try {
                System.out.println(name + " outside bus. Waiting another bus...");
                Thread.sleep(2000 + (int)(Math.random() * 100));
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
