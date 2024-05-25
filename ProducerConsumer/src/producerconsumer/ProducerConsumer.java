package producerconsumer;

import static java.lang.Thread.sleep;

public class ProducerConsumer {
    public ProducerConsumer(){
    }

    private boolean isElementPresent = false;

    public synchronized void producer(){
        try {
            System.out.println("producing element");
            isElementPresent = true;
            notifyAll(); // will invoke wait() to wakeup and go
            System.out.println("produced element");
        } catch (Exception e){
        }
    }

    public synchronized void consumer() {
        try {
            while (!isElementPresent){
                System.out.println("consumer waiting...");
                wait(); // wait and release all monitor locks on common obj
            }
        } catch (Exception e) {
        }

        isElementPresent = false;
        System.out.println("consumed element...");
    }
}
