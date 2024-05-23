package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOps {

  public static void ops() {

    Stream<String> stringStream = Stream.of("I", "Love", "Java");

    // filter() -> to filter the elements
    Stream<String> filterResults = stringStream.filter((String val) -> val.length() >= 3);
    List<String> filteredList = filterResults.collect(Collectors.toList());
    for (String val : filteredList) {
      System.out.println(val);
    }

    // map() -> used to transform each element
    stringStream = Stream.of("I", "Love", "Java");
    Stream<String> mapResults = stringStream.map((String a) -> a.toLowerCase());
    List<String> mapList = mapResults.collect(Collectors.toList());
    for (String val : mapList) {
      System.out.println(val);
    }

    // flatMap() -> iterate over each element of complex collection and helps flatten it
    List<List<String>> listList = Arrays.asList(
        Arrays.asList("I", "Love", "Java"),
        Arrays.asList("I", "Love", "GoLang")
    );
    List<String> stringList = listList.stream().flatMap((List<String> a) -> a.stream())
        .map((String a) -> a.toLowerCase())
        .collect(Collectors.toList());
    for (String a : stringList) {
      System.out.println(a);
    }

    // distinct() -> removes duplicate elements
    Integer[] arr = {1,23,40,23};
    List<Integer> list = Arrays.stream(arr).distinct().collect(Collectors.toList());
    for(Integer val : list){
      System.out.println(val);
    }

    // sorted()
    list = Arrays.stream(arr).sorted().collect(Collectors.toList());
    for(Integer val : list){
      System.out.println(val);
    }

    // Eg -> combining all above
    list = Arrays.stream(arr)
            .filter((Integer a) -> a > 3)
            .peek((Integer a) -> System.out.println(a))
            .map((Integer a) -> -1 * a)
            .sorted()
            .collect(Collectors.toList());
    for(Integer val : list){
      System.out.println(val);
    }

    // primitive int stream
    int[] ints = {1,2,30,90};
    Arrays.stream(ints).filter((int a) -> a > 3);
    // 30, 90


    // mapToInt
    List<String> stringList1 = Arrays.asList("2", "30");
    IntStream intStream =  stringList1.stream().mapToInt((String a) -> Integer.parseInt(a));
    int[] output = intStream.toArray();
    // 2, 30
  }
}
