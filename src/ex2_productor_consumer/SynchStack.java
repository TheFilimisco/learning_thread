package ex2_productor_consumer;

import java.util.Vector;

public class SynchStack {
    private final int MAX_SIZE = 250;
    private Vector buffer = new Vector(400,200);

    public synchronized void push(char c) {
        while (buffer.size() == MAX_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.buffer.add(c);
        this.notifyAll();
        // Siemrpe que trabajes con multiples hilos es mejor
        // decirles a los consumidores que hay un hueco disponible
    }

    public synchronized char pop() {
        char c;
        while (buffer.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        c = (char) buffer.removeLast();
        this.notifyAll();
        return c;
    }
}
