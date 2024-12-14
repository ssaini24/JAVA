package streamsquestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Transaction {
    String day;
    Integer amount;

    public Transaction(String curDay, Integer curAmount){
        day = curDay;
        amount = curAmount;
    }

    public String getDay(){
        return day;
    }

    public Integer getAmount() {
        return amount;
    }
}

class Interval {
    Integer day;
    Integer amount;

    public Interval(Integer curDay, Integer curAmount){
        day = curDay;
        amount = curAmount;
    }

    public Integer getDay(){
        return day;
    }

    public Integer getAmount() {
        return amount;
    }
}

public class StreamQuestions {

    public static void maxLengthString(){
        List<String> fruitsList = Arrays.asList("apple", "banana", "orange", "peaches");
        Optional<String> maxString = fruitsList.stream().max((String a, String b) -> {
            return Integer.compare(a.length(), b.length());
        });
        System.out.println(maxString.get());
        System.out.println("**********");
    }

    public static void mergeTwoSortedLists(){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);
        List<Integer> mergeList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        mergeList.forEach(System.out::println);
        System.out.println("**********");
    }

    public static void intersectionTwoList(){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,4,5,10);
        List<Integer> intersectedList = list1.stream().filter(list2::contains).collect(Collectors.toList());
        intersectedList.forEach(System.out::println);
        System.out.println("**********");
    }

    public static void removeDuplicates(){
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
    }

    public static void sumOfTransactionsOnEachDay(){
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> sumByDay = transactions.stream().collect(Collectors.groupingBy((Transaction a) -> a.getDay(), Collectors.summingInt((Transaction a) -> a.getAmount())));
        sumByDay.forEach((String key, Integer value) -> System.out.println(key + " " + value));
        System.out.println("**********");
    }

    public static void kthSmallestElement(){
        int k = 2;
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int smallest = Arrays.stream(array).sorted().skip(k-1).findFirst().getAsInt();
        System.out.println(smallest);
        System.out.println("**********");
    }

    public static void freqOfEachWord(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> wordCount = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordCount.forEach((String key, Long value) -> System.out.println(key + " " + value));
        System.out.println("**********");
    }

    public static void partitionTwoList(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().collect(Collectors.partitioningBy((Integer a) -> a % 2 == 0));
        List<Integer> evenList = booleanListMap.get(true);
        evenList.forEach(System.out::println);
        System.out.println("##########");
        List<Integer> oddList = booleanListMap.get(false);
        oddList.forEach(System.out::println);
        System.out.println("**********");
    }

    public static void findTotalLengthCovered(){
        List<Interval> intervals = Arrays.asList(new Interval(1, 3),
                new Interval(5, 8), new Interval(10, 12));
        int totalDistance = intervals.stream().mapToInt(Interval -> Interval.amount - Interval.day).sum();
        System.out.println(totalDistance);
        System.out.println("**********");
    }

    public static void findTotalOccurrence(){
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "melon");
        Character target = 'a';
        long count = strings.stream().flatMapToInt(CharSequence::chars).filter((int ch) -> ch == target).count();
        System.out.println(count);
        System.out.println("**********");
    }

    public static void printSingleOccurrenceCharsString(){
        String text = "abcdeabc";
        Map<Integer, Long> countMap = Stream.of(text).flatMapToInt(CharSequence::chars).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        countMap.entrySet().stream().filter(e -> e.getValue() == 2).map(e-> (char) e.getKey().intValue()).forEach(System.out::println);
        System.out.println("**********");
    }

    public static void pairsSumUpToTarget(){
        int target = 12;
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        Set<String> pairs = numbers.stream().flatMap(i -> numbers.stream().map(j -> i+j == target ? (i + " " + j) : "")).collect(Collectors.toSet());
        System.out.println(pairs);
        System.out.println("**********");
    }

    public static void findNonDuplicateNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);
        Map<Integer, Long> mp = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mp.entrySet().stream().filter(entry -> entry.getValue() == 1).forEach(System.out::println);
        System.out.println("**********");
    }

    public static void findLongestString(){
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "kiwi");
        List<String> longestString = strings.stream().sorted((String a, String b) -> Integer.compare(b.length(), a.length())).collect(Collectors.toList());
        System.out.println(longestString.get(0));
        System.out.println("**********");
    }
}
