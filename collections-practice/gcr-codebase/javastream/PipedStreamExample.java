import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            Thread writerThread = new Thread(() -> {
                try {
                    String[] messages = {"Hello", "World", "Java", "Programming"};
                    for (String msg : messages) {
                        pos.write(msg.getBytes());
                        pos.write('\n');
                        Thread.sleep(500);
                    }
                    pos.close();
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });
            
            Thread readerThread = new Thread(() -> {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(pis));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Read: " + line);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });
            
            writerThread.start();
            readerThread.start();
            
            writerThread.join();
            readerThread.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
