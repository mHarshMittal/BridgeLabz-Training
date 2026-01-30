import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 4. Extract all email addresses from a text.
 */
public class ExtractEmails {

    public static List<String> extractEmails(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        System.out.println(extractEmails(text));
    }
}
