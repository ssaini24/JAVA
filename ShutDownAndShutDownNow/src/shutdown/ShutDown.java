package shutdown;

import java.util.concurrent.*;

public class ShutDown {
    public  static void shutDown(){

        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);

        poolExecutor.submit(() -> {
            try{
                Thread.sleep(5000);
            } catch (Exception e){
            }

            System.out.println("thread process executed success");
        });

        // will finish ongoing tasks but cannot accept new tasks, already submitted in queue will execute
        poolExecutor.shutdown();

        boolean isterminated = false;
        try {
            // wait for 2 sec, it terminate returns true
            isterminated =  poolExecutor.awaitTermination(2, TimeUnit.MILLISECONDS);
        } catch (Exception e){

        }

        System.out.println("is executor terminated " + isterminated);

        System.out.println("completed main");

        ThreadLocal local = new ThreadLocal<>();

        local.set(20);
    }
}
