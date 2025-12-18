import java.util.Scanner;
public class yard_miles{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter distance in feet: ");
 int dist = sc.nextInt();
   double yard = dist / 3;
   double mile = yard / 1760;
   System.out.println("The distance in yards is "+yard+" while the distance in miles is "+mile);
}
}