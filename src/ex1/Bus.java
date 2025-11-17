package ex1;

public class Bus {
    private final int AMOUNT_MAX = 10;
    private int amountSeatBus = AMOUNT_MAX;

    public int getAMOUNT_MAX() {
        return AMOUNT_MAX;
    }

    public int getAmountSeatBus() {
        return amountSeatBus;
    }

    public synchronized void getOnPass(int number) {
        while (amountSeatBus == 0) {
            try {
                System.out.println("Bus busy. Waiting...");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        amountSeatBus -= number;
        System.out.println("Get on. Available seats: " + amountSeatBus);
        notifyAll(); // Notifica que hay un asiento menos a todos los hilos
        // (ahora podría no estar lleno)
    }

    public synchronized void getOffPass(int number) {
        while (amountSeatBus == AMOUNT_MAX) {
            try {
                System.out.println("Bus empty. Waiting...");
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        amountSeatBus += number;
        System.out.println("Get off. Available seats: " + amountSeatBus);
        notifyAll(); // Notifica que hay un asiento más a todos los hilos(ahora podría no estar vacío)
    }
}
