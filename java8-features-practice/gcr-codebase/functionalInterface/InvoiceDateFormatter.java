import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatterUtil {
    static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

public class InvoiceDateFormatter {
    public static void main(String[] args) {
        System.out.println(DateFormatterUtil.formatDate(LocalDate.now()));
    }
}
