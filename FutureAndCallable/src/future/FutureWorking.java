package future;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class FutureWorking {

    public static void futureWorking(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2)
        );

        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            try{
                sleep(7000);
            } catch (Exception e){
            }

            System.out.println("Task executed by Thread: " + Thread.currentThread().getName());
        });

        System.out.println("is Done: " + futureObj.isDone());

        try{
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e){
            System.out.println("waited for 2 secs to complete, eventually timeout happened");
        } catch (Exception e){
            System.out.println("");
        }

        try{
            System.out.println("now waiting indefinitely till execution completed");
            futureObj.get();
        } catch (Exception e){
        }

        System.out.println("is finally Done: " + futureObj.isDone());
        System.out.println("is cancelled: " + futureObj.isCancelled());
    }
}
