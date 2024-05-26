import customrejectionhandler.CustomRejectionHandler;
import threadfactory.CustomThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            4,
            10,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(2),
            new CustomThreadFactory(),
                new CustomRejectionHandler()
        );

//        // when 2 threads are busy and queue is full
//        for (int i = 1; i <= 4; i++){
//            threadPoolExecutor.submit(() -> {
//                try{
//                    sleep(5000);
//                } catch (Exception e){
//                }
//
//                System.out.println("Task executed by Thread: " + Thread.currentThread().getName());
//            });
//        }
//
//        threadPoolExecutor.shutdown();

//        // when 2 threads are busy, queue is full, remaining 2 threads from max pool are also busy
//        for (int i = 1; i <= 6; i++){
//            threadPoolExecutor.submit(() -> {
//                try{
//                    sleep(5000);
//                } catch (Exception e){
//                }
//
//                System.out.println("Task executed by Thread: " + Thread.currentThread().getName());
//            });
//        }
//
//        threadPoolExecutor.shutdown();

        // when 2 threads are busy, queue is full, remaining 2 threads from max pool are also busy
        // then for 7th task, we have no thread and queue is also full, it would be rejected
        for (int i = 1; i <= 7; i++){
            threadPoolExecutor.submit(() -> {
                try{
                    sleep(5000);
                } catch (Exception e){
                }

                System.out.println("Task executed by Thread: " + Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();
    }
}