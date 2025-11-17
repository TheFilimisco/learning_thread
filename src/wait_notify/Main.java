package wait_notify;

public class Main {
    public static void main(String[] args) {
        Together together = new Together();

        Producer producer = new Producer(together);
        Consumer consumer = new Consumer(together);

        producer.start();
        consumer.start();
    }
}
