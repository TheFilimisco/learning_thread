package cinta_paquets;

public class Consumer implements Runnable{
    private int num;
    private static int counter = 0;
    private final ConveyorBelt belt;


    public Consumer(ConveyorBelt belt) {
        synchronized (Consumer.class){
            this.belt = belt;
            this.num = counter++;
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){

            String advice = belt.popPackage();
            if (advice.equalsIgnoreCase("Belt is empty")){
                System.out.println("Consumer " + num + " waiting." + advice);
            } else  {
                System.out.println("Consumer " + num + " pop a packet. " + advice);
            }

            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
