package completableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ThenApplyVsThenApplySync {
    public static void thenApplyChaining(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2)
        );

        CompletableFuture<?> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        sleep(1000);
                        System.out.println("thenApply thread used: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "task completed";
                }
        , threadPoolExecutor).thenApply((String a) -> {
            System.out.println("thenApply same thread used: " + Thread.currentThread().getName());
            return a + "with chaining";
        });

        try {
            System.out.println(future.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        CompletableFuture<?> future1 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        sleep(1000);
                        System.out.println("thenApplySync thread used: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "task completed";
                }
        , threadPoolExecutor).thenApplyAsync((String a) -> {
            System.out.println("thenApplySync diff thread used: " + Thread.currentThread().getName());
            return a + "with chaining";
        });

        try {
            System.out.println(future1.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
