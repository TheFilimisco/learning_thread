package cinta_paquets;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private static AtomicInteger counter = new AtomicInteger(0);
    private int num;
    private ConveyorBelt belt;
    public static final char POISON_PILL = '#';


    public static AtomicInteger getCounter() {
        return counter;
    }

    public Producer(ConveyorBelt belt) {
        this.belt = belt;
        this.num = counter.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            char c;
            c = (char) ((Math.random() * 10) + 'A');
            // Push new Package
            System.out.println("Producer " + num + " pushing " + c);
            belt.pushPackage(c);

            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

        }
        belt.pushPackage(POISON_PILL);
    }
}

