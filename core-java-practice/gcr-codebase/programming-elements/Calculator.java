import java.util.Scanner;
public class Calculator
{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 int a = sc.nextInt();
 int b = sc.nextInt();

  
   int division = a/b;
   int addition = a+b;
   int subtraction = a-b;
   int multiplication = a*b;
   System.out.println("The addition is "+addition+" , subtraction  is "+subtraction+" , multiplication is  "+multiplication+" and division is "+division);
}
}