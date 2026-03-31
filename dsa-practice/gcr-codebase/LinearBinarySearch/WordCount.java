import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    public static void main(String[] args) {

        String filePath = "sample.txt";   // file path
        String targetWord = "java";       // word to search
        int count = 0;

        BufferedReader reader = null;

        try {
            FileReader fileReader = new FileReader(filePath);
            reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("Word '" + targetWord + "' occurs " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
