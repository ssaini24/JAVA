package stampedLock;

import sharedResource.SharedResource;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class OptimisticStampedLock {
    public static void stampedLock(){
        SharedResource obj1 = new SharedResource();

        StampedLock stampedLock = new StampedLock();

        Thread thread1 = new Thread(()->obj1.optimisticReadLockProducer(stampedLock));
        // write lock is acquired after optimistic read,
        // then when we came back to optimistic read producer, it fails to update the value
        // as on validate in optimistic read, version gets updated because of write lock
        Thread thread2 = new Thread(()->obj1.stampedWriteLockProducer(stampedLock));

        thread1.start();
        thread2.start();
    }
}
