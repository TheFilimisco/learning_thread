package cinta_paquets;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ConveyorBelt conveyorBelt = new ConveyorBelt();

        Producer producer = new Producer(conveyorBelt);
        Producer producer2 = new Producer(conveyorBelt);

        Consumer consumer = new Consumer(conveyorBelt);
        Consumer consumer2 = new Consumer(conveyorBelt);


        Thread producerThread = new Thread(producer);
        Thread producerThread2 = new Thread(producer2);
        Thread consumerThread = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer2);

        ArrayList<Thread> producers = new ArrayList<>();
        producers.add(producerThread);
        producers.add(producerThread2);

        ArrayList<Thread> consumers = new ArrayList<>();
        consumers.add(consumerThread);
        consumers.add(consumerThread2);



        if (Consumer.getCounter().get() > Producer.getCounter().get()) {
            for (Thread t : producers) {
                t.setPriority(Thread.MAX_PRIORITY);
            }
        }

        if (Consumer.getCounter().get() < Producer.getCounter().get()) {
            for (Thread t : consumers) {
                t.setPriority(Thread.MAX_PRIORITY);
            }
            
        }

        producerThread.start();
        consumerThread.start();
        producerThread2.start();
        consumerThread2.start();



        producerThread.join();
        consumerThread.join();
        producerThread2.join();
        consumerThread2.join();

        Thread.sleep(1000);

        System.out.println("Finish to factory..." + conveyorBelt.getSize());
        System.out.println("All threads have completed their work.");
    }
}
