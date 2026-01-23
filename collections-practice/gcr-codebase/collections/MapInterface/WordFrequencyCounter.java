import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        String cleanedText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
    
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> result = countWordFrequency(text);
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Output: " + result);
    }
}
