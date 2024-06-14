package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamVsParallelStream {

    public static void vs() {

        System.out.println("******Seq Vs Parallel***********");

        // Use a much larger list for better comparison
        List<Integer> list = IntStream.rangeClosed(1, 1000000)
                .boxed()
                .collect(Collectors.toList());

        // Warm-up phase
        // The JVM was warmed up and optimized to handle the parallel tasks efficiently.
        for (int i = 0; i < 5; i++) {
            list.stream()
                    .map(a -> a * a)
                    .map(a -> a * a)
                    .map(a -> a * a)
                    .collect(Collectors.toList());

            list.parallelStream()
                    .map(a -> a * a)
                    .map(a -> a * a)
                    .map(a -> a * a)
                    .collect(Collectors.toList());
        }

        long start = System.currentTimeMillis();

        list.stream()
                .map(a -> a * a)
                .map(a -> a * a)
                .map(a -> a * a)
                .collect(Collectors.toList());

        System.out.println("Time taken by sequential stream: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();

        // The work was divided among multiple threads, allowing many numbers to be processed at the same time.
        list.parallelStream()
                .map(a -> a * a)
                .map(a -> a * a)
                .map(a -> a * a)
                .collect(Collectors.toList());

        System.out.println("Time taken by parallel stream: " + (System.currentTimeMillis() - start) + " ms");
    }
}
