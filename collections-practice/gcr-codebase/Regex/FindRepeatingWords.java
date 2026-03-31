import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 14. Find repeating consecutive words in a sentence.
 */
public class FindRepeatingWords {

    public static List<String> findRepeatingWords(String text) {
        Set<String> result = new LinkedHashSet<>();
        if (text == null) return new ArrayList<>(result);
        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        System.out.println(findRepeatingWords(text));
    }
}
