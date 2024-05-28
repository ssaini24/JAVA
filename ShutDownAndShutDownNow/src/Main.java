import shutdown.ShutDown;
import shutdownnow.ShutDownNow;
import threadlocal.ThreadLocalImpl;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
//        ShutDown.shutDown();
//        ShutDownNow.shutDownNow();


//        ThreadLocalImpl.threadLocal();
        ThreadLocalImpl.threadLocalClean();
    }
}