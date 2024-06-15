package runnableinterface;

import static java.lang.Thread.sleep;

public class ThreadCreationWay1 {
    public static void main(){
        Thread thread = new Thread(new RunnableInterfaceImpl());
        thread.start();
    }
}
