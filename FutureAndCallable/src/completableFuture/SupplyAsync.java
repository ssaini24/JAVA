package completableFuture;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class SupplyAsync {

    public static void supplyAsync() {
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
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "task completed";
                }
        );

        try {
            System.out.println(future.get());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
