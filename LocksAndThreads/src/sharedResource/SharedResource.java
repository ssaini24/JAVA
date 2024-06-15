package sharedResource;

import readWriteLocks.ReadWrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

public class SharedResource {
    public SharedResource(){
    }

    private boolean isElementPresent = false;
    private static Integer val = 10;

    public void producer(ReentrantLock reentrantLock){
        try {
            reentrantLock.lock();
            System.out.println("producing element by: " + Thread.currentThread().getName());
            isElementPresent = true;
            sleep(1000);
            System.out.println("produced element by: " + Thread.currentThread().getName());
            reentrantLock.unlock();
        } catch (Exception e){
        }
    }

    public void readLockProducer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.readLock().lock();
            System.out.println("read lock acquired by: " + Thread.currentThread().getName());
            isElementPresent = true;
            sleep(5000);
            System.out.println("read lock released by: " + Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        } catch (Exception e){
        }
    }

    public void writeLockConsumer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.writeLock().lock();
            System.out.println("write lock acquired by: " + Thread.currentThread().getName());
            isElementPresent = false;
            System.out.println("write lock released by: " + Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();
        } catch (Exception e){
        }
    }

    public void optimisticReadLockProducer(StampedLock stampedLock){
        try {
            Long stamp = stampedLock.tryOptimisticRead();
            System.out.println("taken optimistic lock..now trying to update value...");
            val = 11;
            isElementPresent = true;
            sleep(5000);
            if(stampedLock.validate(stamp)){
                System.out.println("successfully updated value");
            } else {
                System.out.println("unable to update..aborting");
                val = 10;
            }

            System.out.println("no lock to release! as never acquired any");
        } catch (Exception e){
        }
    }

    public void stampedWriteLockProducer(StampedLock stampedLock){
        try {
            Long stamp = stampedLock.writeLock();
            System.out.println("taken write lock");
            val = 11;
            isElementPresent = true;
            System.out.println("validating write lock stamp: " + stampedLock.validate(stamp));
            stampedLock.unlockWrite(stamp);
            System.out.println("released write lock");
        } catch (Exception e){
        }
    }
}
