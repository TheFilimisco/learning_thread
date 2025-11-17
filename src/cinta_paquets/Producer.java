package cinta_paquets;

public class Producer implements Runnable{
    private static int counter = 0;
    private int num;
    private ConveyorBelt belt;

    public Producer(ConveyorBelt belt){
        synchronized (Producer.class){
            this.belt = belt;
            this.num = counter++;
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
                char c;
                c = (char) ((Math.random() * 10) + 'A');
                // Push new Package
                String advice = belt.pushPackage(c);

                if (advice.equals("Belt is full")) {
                    System.out.println("Producer " + num + " waiting.. " + advice);
                } else {
                    System.out.println("Producer " + num + " push package.. " + advice);
                }

                try {
                    Thread.sleep((int) (Math.random() * 300));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

