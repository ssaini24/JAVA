import producerconsumer.ProducerConsumer;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        ProducerConsumer commonObj = new ProducerConsumer();

        Thread thread = new Thread(() -> {
            try {
                sleep(10000); // call producer after 10 secs to help consumer wait for msg
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            commonObj.producer();
        });
        Thread thread1 = new Thread(commonObj::consumer);

        thread.start();
        thread1.start();
    }
}