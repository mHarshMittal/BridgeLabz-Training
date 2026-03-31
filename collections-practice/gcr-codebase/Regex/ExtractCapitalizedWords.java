import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 5. Extract all capitalized words from a sentence.
 */
public class ExtractCapitalizedWords {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (!"The".equals(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        System.out.println(extractCapitalizedWords(text));
    }
}
