package ex2_productor_consumer;

public class Consumer implements Runnable {
    private static int counter = 0; // contador de Producer
    private int num = 0;
    private SynchStack  stack = new SynchStack ();

    public Consumer() {
        synchronized (Consumer.class) {
            this.num = counter++;
        }
    }

    public void setStack(SynchStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        char c;
        for(int i=0; i<200; i++){
            //Treiem un caràcter de la pila
            c= this.stack.pop();
            System.out.println("Consumer " + num + ": " + c);
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
