package cinta_paquets;

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

        producerThread.start();
        consumerThread.start();
        producerThread2.start();
        consumerThread2.start();

        producerThread.join();
        producerThread2.join();
        consumerThread.join();
        consumerThread2.join();


        System.out.println("Finish to factory...");
        System.out.println("All threads have completed their work.");
    }
}
