package collectionsPart1;

import java.util.ArrayList;
import java.util.List;

public class ForeachImpl {

    public ForeachImpl() {}

    public void Foreach(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        integerList.forEach((Integer a)-> System.out.println(a));
    }
}
