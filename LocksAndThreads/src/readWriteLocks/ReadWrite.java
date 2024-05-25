package readWriteLocks;

import sharedResource.SharedResource;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    public static void readWriteLock(){
        SharedResource obj1 = new SharedResource();
        SharedResource obj2 = new SharedResource();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        // both threads will go into producing item simultaneously
        Thread thread1 = new Thread(()->obj1.readLockProducer(readWriteLock));
        Thread thread2 = new Thread(()->obj2.readLockProducer(readWriteLock));

        // as read & write cannot be applied simultaneously using same lock object
        // write waits for read lock to release, then only acquire itself
        // Shared with Exclusive (not possible)
        SharedResource obj3 = new SharedResource();
        Thread thread3 = new Thread(()->obj3.writeLockConsumer(readWriteLock));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
