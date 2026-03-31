import java.io.*;

public class ReadLargeFileLineByLine {
    public static void main(String[] args) {
        String filename = "largefile.txt";
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
            
            br.close();
            fr.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
