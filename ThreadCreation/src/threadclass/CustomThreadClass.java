package threadclass;

public class CustomThreadClass extends Thread {

    @Override
    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("custom class thread working: " + Thread.currentThread().getName());
    }
}
