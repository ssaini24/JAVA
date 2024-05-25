package reentrantLock;

import sharedResource.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClass {

    // despite we have diff shared resource obj, this lock ensures only one object go into critical section
    // at single time (as opposed to synchronized locks)
    public static void reentrantLock(){
        SharedResource obj1 = new SharedResource();
        SharedResource obj2 = new SharedResource();

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(()->obj1.producer(reentrantLock));
        Thread thread2 = new Thread(()->obj2.producer(reentrantLock));

        thread1.start();
        thread2.start();
    }
}
