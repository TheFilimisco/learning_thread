package ex2_productor_consumer;

public class Producer implements Runnable{
    private static int counter = 0; //Contador de Producer instanciats
    private int num = 0; //Número d'instància
    private SynchStack stack = new SynchStack();

    public Producer() {
        synchronized (Producer.class) {
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
            //Calculem un caràcter a l'atzar
            c= (char) ((Math.random() * 26) + 'A');
            System.out.println("Producer " + num + ": " + c);
            this.stack.push(c);
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
