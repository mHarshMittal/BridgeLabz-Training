import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the date in formate given  (yyyy-MM-dd): ");
        String inpDate = sc.nextLine();
        
        LocalDate inputDate = LocalDate.parse(inpDate);
        System.out.println("Original date: " + inputDate);
        
        LocalDate afterAddition = inputDate
            .plusDays(7)
            .plusMonths(1)
            .plusYears(2);
        
        System.out.println("After adding 7 days, 1 month, and 2 years: " + afterAddition);
        
        LocalDate finalDate = afterAddition.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);
        
        sc.close();
    }
}

