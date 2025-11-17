package cinta_paquets;

import java.util.Vector;

public class ConveyorBelt {
    private final int MAX_SIZE = 20;
    private Vector capacity = new Vector(30, 10);

    public synchronized String pushPackage (char c){
        while (capacity.size() == MAX_SIZE){
            try {
                wait();
                return "Belt is full";
            } catch (InterruptedException e) {}
        }
        capacity.add(c);
        this.notifyAll();
        return "Capacity is: " + capacity.size();
    }

    public synchronized String popPackage (){
        while(capacity.isEmpty()){
            try {
                wait();
                return "Belt is empty";
            } catch (InterruptedException e) {}
        }

        capacity.removeLast();
        this.notifyAll();
        return "Capacity is: " + capacity.size();
    }

}
