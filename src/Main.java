import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Main {
    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog";
        String[] words = text.split("\\s+");
        long countWords = Arrays.stream(words)
                .map(String::toLowerCase)
                .count();
        System.out.printf("В тексте: %s слов \n", countWords);
        Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}