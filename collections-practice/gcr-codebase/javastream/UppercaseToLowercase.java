import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String line;
            while ((line = br.readLine()) != null) {
                String lowerLine = line.toLowerCase();
                bw.write(lowerLine);
                bw.newLine();
            }
            
            br.close();
            fr.close();
            bw.close();
            fw.close();
            
            System.out.println("File converted successfully!");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
