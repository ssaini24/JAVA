import completableFuture.SupplyAsync;
import completableFuture.ThenApplyVsThenApplySync;
import future.FutureWorking;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
//        FutureWorking.futureWorking();
//        SupplyAsync.supplyAsync();
        ThenApplyVsThenApplySync.thenApplyChaining();
    }
}