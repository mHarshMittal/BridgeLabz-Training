import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 6. Extract dates in dd/mm/yyyy format from text.
 */
public class ExtractDates {

    public static List<String> extractDates(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        System.out.println(extractDates(text));
    }
}
