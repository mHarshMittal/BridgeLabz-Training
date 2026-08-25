public class WordsStartingEndingVowels {

    public static void main(String[] args) {

        String[] words = {"apple", "banana", "area", "India", "umbrella", "cat"};

        for (String word : words) {

            String lowerWord = word.toLowerCase();

            char first = lowerWord.charAt(0);
            char last = lowerWord.charAt(lowerWord.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                System.out.println(word);
            }
        }
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }
}