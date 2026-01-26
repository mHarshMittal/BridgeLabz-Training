import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";
        
        long startTime, endTime;
        
        System.out.println("Copying with Buffered Streams...");
        startTime = System.nanoTime();
        copyWithBufferedStreams(sourceFile, destBuffered);
        endTime = System.nanoTime();
        long bufferedTime = endTime - startTime;
        System.out.println("Buffered Stream Time: " + (bufferedTime / 1_000_000) + " ms");
        
        System.out.println("\nCopying with Normal Streams...");
        startTime = System.nanoTime();
        copyWithNormalStreams(sourceFile, destUnbuffered);
        endTime = System.nanoTime();
        long unbufferedTime = endTime - startTime;
        System.out.println("Unbuffered Stream Time: " + (unbufferedTime / 1_000_000) + " ms");
        
        System.out.println("\nPerformance Difference: " + ((unbufferedTime - bufferedTime) / 1_000_000) + " ms");
    }
    
    static void copyWithBufferedStreams(String source, String dest) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            bis.close();
            bos.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void copyWithNormalStreams(String source, String dest) {
        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest);
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
            fis.close();
            fos.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
