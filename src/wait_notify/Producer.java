package wait_notify;

public class Producer extends Thread {
    private final Together together;

    public Producer(Together together) {
        this.together = together;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this.together) {
                together.setNumber(i);
                System.out.println("Producer " + i);
            }
        }

    }
}
