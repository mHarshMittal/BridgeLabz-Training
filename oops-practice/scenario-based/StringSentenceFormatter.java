/*Strings – Sentence Formatter
1. Scenario: A text editing tool receives poorly formatted input from users. Your task is to auto-correct formatting by fixing spacing and capitalizing the first letter of each sentence.
Problem:
Write a method that takes a paragraph as input and returns a corrected version with:
● One space after punctuation,
● Capital letter after period/question/exclamation marks,
● Trimmed extra space 
*/

public class StringSentenceFormatter {
    public static void main(String[] args) {
        String input = "this is a test.  this is only a test!is it working? yes,it is.   ";
        String formatted = formatParagraph(input);
        System.out.println(formatted);
    }

    public static String formatParagraph(String paragraph) {
        // Trim leading and trailing spaces
        paragraph = paragraph.trim();

        // Replace multiple spaces with a single space
        paragraph = paragraph.replaceAll("\\s+", " ");

        // Ensure one space after punctuation marks
        paragraph = paragraph.replaceAll("([.!?])\\s*", "$1 ");

        // Capitalize the first letter of each sentence
        StringBuilder formatted = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : paragraph.toCharArray()) {
            if (capitalizeNext && Character.isLetter(c)) {
                formatted.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                formatted.append(c);
            }
            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }

        return formatted.toString().trim();
    }
}
