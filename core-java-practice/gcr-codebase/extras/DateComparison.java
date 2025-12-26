import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String date1Inp = sc.nextLine();
        LocalDate date1 = LocalDate.parse(date1Inp);
        
        System.out.print("Enter second date (yyyy-MM-dd): ");
        String date2Inp = sc.nextLine();
        LocalDate date2 = LocalDate.parse(date2Inp);
        
        System.out.println("\nDate 1: " + date1);
        System.out.println("Date 2: " + date2);
        System.out.println();
        
        if (date1.isBefore(date2)) {
            System.out.println("Date 1 is before Date 2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date 1 is after Date 2");
        } else if (date1.isEqual(date2)) {
            System.out.println("Date 1 is the same as Date 2");
        }
        
        sc.close();
    }
}

