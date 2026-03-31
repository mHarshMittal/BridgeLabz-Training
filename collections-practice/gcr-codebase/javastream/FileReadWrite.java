import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            fis.close();
            fos.close();
            
            System.out.println("File copied successfully!");
            
        } catch (IOException e) {
            System.out.println("Error: Source file does not exist or cannot be read.");
        }
    }
}
