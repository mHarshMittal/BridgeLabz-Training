import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {

        int count = 0;
        int batch = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("large.csv"));
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                count++;
                batch++;


                if (batch == 100) {
                    System.out.println("Records processed: " + count);
                    batch = 0;
                }
            }

            if (batch > 0) {
                System.out.println("Records processed: " + count);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

