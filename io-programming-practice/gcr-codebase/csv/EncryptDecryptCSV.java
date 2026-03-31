import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    static String encrypt(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    static String decrypt(String s) {
        return new String(Base64.getDecoder().decode(s));
    }

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("employees.csv");
            fw.write("ID,Name,Email,Salary\n");
            fw.write("1,Alice," + encrypt("alice@gmail.com") + "," + encrypt("60000") + "\n");
            fw.write("2,Bob," + encrypt("bob@yahoo.com") + "," + encrypt("50000") + "\n");
            fw.close();

            BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                System.out.println(
                        d[0] + " " +
                        d[1] + " " +
                        decrypt(d[2]) + " " +
                        decrypt(d[3])
                );
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

