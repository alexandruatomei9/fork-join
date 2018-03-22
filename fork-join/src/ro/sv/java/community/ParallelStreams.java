package ro.sv.java.community;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {
        Stream.of("John", "Mike", "Ryan", "Donald", "Matthew").forEach(System.out::println);

        System.out.println("------");

        Arrays.asList("John", "Mike", "Ryan", "Donald", "Matthew").parallelStream().forEach(System.out::println);

        System.out.println("------");

        count();

        System.out.println("------");

        int[] unsortedArray = {1, 3, 4, 2, 9, 6, 5};
        Arrays.parallelSort(unsortedArray);
        Arrays.stream(unsortedArray).forEach(i -> System.out.print(i + " "));
    }

    private static void count() {
        final long count = IntStream.range(1, 50)
                .parallel()
                .filter(ParallelStreams::isPrime).count();
        System.out.println("Count - " + count);
    }

    private static boolean isPrime(final int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
    }
}
