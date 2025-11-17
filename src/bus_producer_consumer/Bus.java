package bus_producer_consumer;

import java.util.Vector;

public class Bus {
    private final int AMOUNT_MAX = 20;
    private Vector amountSeating = new Vector(400, 200);

    public synchronized void push(char c) {
        while (amountSeating.size() == AMOUNT_MAX) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.amountSeating.add(c);
        this.notifyAll();
        // Siemrpe que trabajes con multiples hilos es mejor
        // decirles a los consumidores que hay un hueco disponible
    }

    public synchronized char pop() {
        char c;
        while (amountSeating.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        c = (char) amountSeating.removeLast();
        this.notifyAll();
        return c;
    }

}
