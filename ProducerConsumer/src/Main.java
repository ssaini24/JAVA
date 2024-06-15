import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
//        ProducerConsumer commonObj = new ProducerConsumer();
//
//        Thread thread = new Thread(() -> {
//            try {
//                sleep(10000); // call producer after 10 secs to help consumer wait for msg
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            commonObj.producer();
//        });
//        Thread thread1 = new Thread(commonObj::consumer);
//
//        thread.start();
//        thread1.start();

        AtomicInteger a = new AtomicInteger(10);

        for(int i = 0; i < 100; i++){
            Thread t1 = new Thread(()-> System.out.println(a.addAndGet(1)));
            Thread t2 = new Thread(()-> System.out.println(a.addAndGet(1)));
            Thread t3 = new Thread(()-> System.out.println(a.addAndGet(1)));
            Thread t4 = new Thread(()-> System.out.println(a.addAndGet(1)));

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(a);
    }
}