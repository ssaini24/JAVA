package threadclass;

public class ThreadCreationWay2 {
    public static void main(){
        Thread thread = new CustomThreadClass();
//        try {
//            thread.sleep(1000, 0);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        thread.start();
    }
}
