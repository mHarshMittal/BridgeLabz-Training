import java.util.Scanner;


public class TempConverter {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        
        int choice = sc.nextInt();
        
        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahr = sc.nextDouble();
            double celsius = fahrToCelsius(fahr);
            System.out.println(fahr + "°F = " + celsius + "°C");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();
            double fahrenheit = celsiusToFahr(celsius);
            System.out.println(celsius + "°C = " + fahrenheit + "°F");
        } else {
            System.out.println("Invalid choice.");
        }
        
        sc.close();
    }
    
  
    public static double fahrToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
    
   
    public static double celsiusToFahr(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
}

