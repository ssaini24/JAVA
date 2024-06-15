package runnableinterface;

import static java.lang.Thread.sleep;

public class RunnableInterfaceImpl implements Runnable {
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("runnable thread working: " + Thread.currentThread().getName());
    }
}
