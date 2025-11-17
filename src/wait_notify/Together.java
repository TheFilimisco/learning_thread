package wait_notify;

public class Together {
    private int number;
    private volatile boolean writable = true; // productor trabaja primero

    //Volatile
    /*Todos ven el valor en tiempo real
    * Siempre se lee de memoria principal
    * Reordenación limitada y segura
    * */

    public synchronized void setNumber(int number){
        // Condition for producer to wait for consumer
        while(!this.writable){ // productor espera si no puede escribir
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        //perfom some work
        this.number = number;

        //Allow consumer to work
        this.writable = false;
        notify();
    }

    public synchronized int getNumber(){
        // the condition for consumer to wait to producer
        while(this.writable){ // consumidor espera si aun no ha escrito
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // perform some work
        int numberCopy = this.number;

        //Allow producer to work
        this.writable = true;
        notify();
        return numberCopy;
    }

}
