import runnableinterface.ThreadCreationWay1;
import threadclass.ThreadCreationWay2;

public class Main {
    public static void main(String[] args) {
        System.out.println("starting main thread: " + Thread.currentThread().getName());
        ThreadCreationWay1.main();
        ThreadCreationWay2.main();
        System.out.println("stopping main thread: " + Thread.currentThread().getName());
    }
}