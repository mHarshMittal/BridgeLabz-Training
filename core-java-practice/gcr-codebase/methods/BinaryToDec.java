import java.util.Scanner;

public class BinaryToDec {
    public static int binaryToDeci(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary number: ");
        String bin = sc.nextLine();
        System.out.println("Decimal: " + binaryToDeci(bin));

        sc.close();
    }
    
}