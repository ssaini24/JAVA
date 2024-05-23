package collectionsPart1;

import java.util.ArrayList;
import java.util.List;

public class EnhancedLoop {

    public static void loop(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        // enhanced for loop
        for (Integer i : integerList){
            System.out.println(i);
        }
    }
}
