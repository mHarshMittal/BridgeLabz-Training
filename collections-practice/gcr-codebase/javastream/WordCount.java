import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filename = "textfile.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            br.close();
            fr.close();
            
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            System.out.println("Top 5 Most Frequent Words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords) {
                if (count < 5) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                    count++;
                } else {
                    break;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
