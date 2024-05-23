package collectionsPart1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorImpl {

    public  static void iteration(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        Iterator<Integer> integerIterator = integerList.iterator();

        while (integerIterator.hasNext()){
            Integer val = integerIterator.next();
            System.out.println(val);
        }
    }
}
