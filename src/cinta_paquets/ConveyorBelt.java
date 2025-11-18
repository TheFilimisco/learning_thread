package cinta_paquets;

import java.util.Vector;

public class ConveyorBelt {
    private final int MAX_SIZE = 20;
    private Vector capacity = new Vector(30, 10);



    public synchronized void pushPackage (char c){
        while (capacity.size() == MAX_SIZE){
            try {
                wait();
                System.out.println("Belt is full"); ;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        capacity.add(c);
        this.notifyAll();
        System.out.println("Capacity is: " + capacity.size());
    }

    public synchronized char popPackage (){
        while(capacity.isEmpty()){
            try {
                wait();
                System.out.println("Belt is empty");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        char c = (char) capacity.removeLast();
        this.notifyAll();
        System.out.println("Capacity is: " + capacity.size());
        return c;
    }
    public synchronized int getSize() {
        return capacity.size();
    }
}
