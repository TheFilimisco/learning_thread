package cinta_paquets;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable{
    private int num;
    private static AtomicInteger counter = new AtomicInteger(0);
    private final ConveyorBelt belt;

    public static AtomicInteger getCounter() {
        return counter;
    }

    public Consumer(ConveyorBelt belt) {
        this.belt = belt;
        this.num = counter.incrementAndGet();
    }

    @Override
    public void run() {
        while (true){
            char getPackage = belt.popPackage();
            System.out.println("Consumer " + num + " processed package: " + getPackage);

            if(getPackage == Producer.POISON_PILL){
                System.out.println("Consumer " + num + " is stopping");
                break;
            }

           /* try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }*/
        }
    }
}
