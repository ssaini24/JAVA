package BillPughWay;

public class DBConnectionImpl {

    public static void makeDBConnection(){

        Thread thread1 = new Thread(()->{
            DBConnection.getDBInstance();
        });

        Thread thread2 = new Thread(()->{
            DBConnection.getDBInstance();
        });

        // Now, executing threads in parallel
        // you will observe initialization of Db Object only once
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
