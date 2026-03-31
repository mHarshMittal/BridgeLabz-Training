import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is easy and java is powerful";

        Map<String, Integer> wordCount =
                Arrays.stream(text.split(" "))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1,
                                Integer::sum
                        ));

        System.out.println(wordCount);
    }
}
