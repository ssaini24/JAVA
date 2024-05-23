package collectionsPart1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForeachImpl {

    public ForeachImpl() {}

    public static void Foreach(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        // for each method
        integerList.forEach((Integer a)-> System.out.println(a));

        Collections.sort(integerList);
    }
}
