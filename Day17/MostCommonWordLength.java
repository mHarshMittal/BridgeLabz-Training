import java.util.HashMap;
import java.util.Map;

public class MostCommonWordLength {

    public static void main(String[] args) {

        String sentence = "Java is very easy to learn Java programming";

        String[] words = sentence.split(" ");

        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {

            int length = word.length();

            map.put(length, map.getOrDefault(length, 0) + 1);
        }

        int mostCommonLength = 0;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonLength = entry.getKey();
            }
        }

        System.out.println(mostCommonLength);
    }
}