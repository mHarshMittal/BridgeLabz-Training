public class LinearSearch2 {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Java is a programming language",
            "Linear search is simple and straightforward",
            "Binary search is more efficient"
        };
        
        String word1 = "fox";
        System.out.println("Searching for: \"" + word1 + "\"");
        System.out.println("Result: " + findSentenceWithWord(sentences, word1));
        System.out.println();
        
        String word2 = "search";
        System.out.println("Searching for: \"" + word2 + "\"");
        System.out.println("Result: " + findSentenceWithWord(sentences, word2));
        System.out.println();
        
        String word3 = "missing";
        System.out.println("Searching for: \"" + word3 + "\"");
        System.out.println("Result: " + findSentenceWithWord(sentences, word3));
    }
}
