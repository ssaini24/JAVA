package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalImpl {

    public static void threadLocal(){
        ThreadLocal threadLocal = new ThreadLocal();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(() -> {
            System.out.println("setting thread local obj for: " + Thread.currentThread().getName());
            threadLocal.set(Thread.currentThread().getName());
        });

        for (int i = 0; i < 15; i++){
            executor.submit(()->{
                System.out.println(threadLocal.get());
            });
        }
    }

    public static void threadLocalClean(){
        ThreadLocal threadLocal = new ThreadLocal();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("setting thread local obj for: " + Thread.currentThread().getName());
            threadLocal.remove(); // internally will get current thread,
            // fetched its thread local and removes it
        });

        for (int i = 0; i < 15; i++){
            executor.submit(()->{
                System.out.println(threadLocal.get());
            });
        }
    }
}
