package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Diff ways to create stream
public class Streams {

  // 4 ways to create streams
  public static void createStreams() {

    System.out.println("******Create Streams***********");

    // list stream
    List<String> stringList = new ArrayList<>();
    Stream<String> stream = stringList.stream();

    // array stream
    Integer[] integers = new Integer[10];
    Stream<Integer> integerStream = Arrays.stream(integers);

    // using static method
    Stream<Integer> stream1 = Stream.of(100, 200);

    // using stream builder
    Stream.Builder<Integer> streamBuilder = Stream.builder();
    streamBuilder.add(100).add(200);
    Stream<Integer> stream2 = streamBuilder.build();

    // stream iterate -> must give limit else go infinite
    // seed being the initial element and 2nd param is the ops
    // of adding 1000 into prev element
    Stream<Integer> streamIterate = Stream.iterate(1000, (Integer a) -> 1000+a).limit(5);
    streamIterate.peek((Integer a) -> System.out.println(a)).count();
  }
}
