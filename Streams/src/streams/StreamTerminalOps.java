package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// ops act as terminal, trigger closing/processing of streams
public class StreamTerminalOps {

    public static void ops(){

        System.out.println("******Terminal Ops***********");

        // foreach() -> perform action on each element of stream
        List<Integer> arr = Arrays.asList(2, 30, 9);
        arr.stream().forEach((Integer a) -> System.out.println(a));


        // toArray() -> collects elements of stream into Array
        Integer[] arr2 = arr.stream().toArray((int size) -> new Integer[size]);
        for (int val : arr2){
            System.out.println(val);
        }

        // reduce() -> does reduction on the elements of the stream (add all elements one by one in ans)
        Optional<Integer> reducedValue = arr.stream().reduce((Integer a, Integer b) -> a + b);
        System.out.println(reducedValue.get());

        // min() -> give first min value if below comparator passed, if b-a then max value will be passed
        Optional<Integer> value = arr.stream().min((Integer a, Integer b) -> a-b);
        System.out.println(value.get());

        // count() -> returns count of streams

        // anyMatch()
        boolean anyMatch = arr.stream().anyMatch((Integer val) -> val > 9);
        System.out.println(anyMatch);
    }
}
