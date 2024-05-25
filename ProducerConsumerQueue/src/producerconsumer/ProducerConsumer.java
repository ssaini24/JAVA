package producerconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class ProducerConsumer {
    public ProducerConsumer(){
    }

    private static final Integer size = 10;

    private List<Integer> arr = new ArrayList<>(size);

    private static Integer currentIndex = -1;

    public synchronized void producer(){
        try {
            while (true){
                while (currentIndex >= size -1)
                    wait();

                System.out.println("producing element");
                arr.add(10);
                currentIndex++;
                System.out.println("produced element");
                notify(); // will invoke wait() to wakeup and go
                // after notify() again there is a fight between which thread (producer/consumer)
                // will run. Job of scheduler to decide, we do not have control over it!
                sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage() + "*****");
        }
    }

    public synchronized void consumer() {
        try {
            while (true) {
                System.out.println("consumer waiting...");
                while (currentIndex < 0)
                    wait();

                arr.remove(currentIndex);
                currentIndex--;
                System.out.println("consumed element...");
                notify();
                sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage() + "*****");
        }
    }
}
