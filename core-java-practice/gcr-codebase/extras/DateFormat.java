import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateFormat {
    
    public static void main(String[] args) {
        LocalDate currDate = LocalDate.now();
        
        DateTimeFormatter formate1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formate2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formate3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        System.out.println("Current date in different formats:\n");
        System.out.println("dd/MM/yyyy format: " + currDate.format(formate1));
        System.out.println("yyyy-MM-dd format: " + currDate.format(formate2));
        System.out.println("EEE, MMM dd, yyyy format: " + currDate.format(formate3));
    }
}

