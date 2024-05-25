import readWriteLocks.ReadWrite;
import reentrantLock.ReentrantLockClass;
import stampedLock.OptimisticStampedLock;

public class Main {
    public static void main(String[] args) {
//        ReentrantLockClass.reentrantLock();
//        ReadWrite.readWriteLock();
        OptimisticStampedLock.stampedLock();
    }
}