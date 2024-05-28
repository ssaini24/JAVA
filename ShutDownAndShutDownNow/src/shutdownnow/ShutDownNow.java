package shutdownnow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownNow {
    public  static void shutDownNow(){

        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);

        poolExecutor.submit(() -> {
            try{
                Thread.sleep(5000);
            } catch (Exception e){
            }

            System.out.println("thread process terminated success");
        });

        // will terminate/execute fast ongoing tasks and cannot accept new tasks,
        // already submitted in queue will never execute
        poolExecutor.shutdownNow();

        System.out.println("completed main");
    }
}
