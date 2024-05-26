package threadfactory;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

    public CustomThreadFactory(){};

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);

        return thread;
    }
}
