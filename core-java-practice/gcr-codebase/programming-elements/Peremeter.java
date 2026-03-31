import java.util.Scanner;

public class Peremeter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the  Perimeter: ");
    int perim = sc.nextInt();
    double side = perim / 4;
    System.out.println("The length of the side is " + side + " whose perimeter is " + perim);
    sc.close();
    
  }
}