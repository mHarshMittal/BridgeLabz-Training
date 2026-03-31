import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 13. Extract currency values from text ($45.99 or 10.50).
 */
public class ExtractCurrencyValues {

    public static List<String> extractCurrencyValues(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        System.out.println(extractCurrencyValues(text));
    }
}
