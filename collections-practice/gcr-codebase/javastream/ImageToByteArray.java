import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImage = "input.jpg";
        String outputImage = "output.jpg";
        
        try {
            FileInputStream fis = new FileInputStream(inputImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            byte[] imageBytes = baos.toByteArray();
            
            fis.close();
            baos.close();
            
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);
            
            byte[] writeBuffer = new byte[1024];
            int bytesWritten;
            
            while ((bytesWritten = bais.read(writeBuffer)) != -1) {
                fos.write(writeBuffer, 0, bytesWritten);
            }
            
            bais.close();
            fos.close();
            
            System.out.println("Image converted and saved successfully!");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
