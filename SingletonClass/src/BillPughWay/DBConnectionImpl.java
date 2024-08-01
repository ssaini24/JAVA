package BillPughWay;

import java.util.concurrent.CountDownLatch;

public class DBConnectionImpl {

    public static void makeDBConnection(){

        CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DBConnection.getDBInstance();
        });

        Thread thread2 = new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DBConnection.getDBInstance();
        });

        // Now, executing threads in parallel
        // you will observe initialization of Db Object only once
        thread1.start();
        thread2.start();

        latch.countDown();
    }
}
