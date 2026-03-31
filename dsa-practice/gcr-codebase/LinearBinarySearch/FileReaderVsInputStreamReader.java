import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) {
        String fileName = "large_file.txt";
        createLargeFile(fileName, 100 * 1024 * 1024);
        
        long startTime = System.currentTimeMillis();
        int wordCount1 = countWordsWithFileReader(fileName);
        long endTime = System.currentTimeMillis();
        long fileReaderTime = endTime - startTime;
        
        startTime = System.currentTimeMillis();
        int wordCount2 = countWordsWithInputStreamReader(fileName);
        endTime = System.currentTimeMillis();
        long inputStreamReaderTime = endTime - startTime;
        
        System.out.println("=== FileReader vs InputStreamReader ===");
        System.out.println("FileReader word count: " + wordCount1);
        System.out.println("FileReader time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader word count: " + wordCount2);
        System.out.println("InputStreamReader time: " + inputStreamReaderTime + " ms");
    }
    
    private static int countWordsWithFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
    
    private static int countWordsWithInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
    
    private static void createLargeFile(String fileName, long sizeInBytes) {
        File file = new File(fileName);
        if (file.exists() && file.length() >= sizeInBytes) {
            return;
        }
        
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String sampleText = "The quick brown fox jumps over the lazy dog. ";
            long written = 0;
            while (written < sizeInBytes) {
                bw.write(sampleText);
                written += sampleText.getBytes(StandardCharsets.UTF_8).length;
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
}
