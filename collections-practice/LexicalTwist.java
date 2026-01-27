/*Lexical Twist
Leo loves puzzles and he enjoys creating challenges for his friends. Today, Leo has
a new puzzle for his friend, involving two words. The task is to process the words
and perform various transformations and analyses based on specific conditions.
Requirements:
1. Check if the second word is a reversed version of the first word:
- The second word is considered the "reversed version" of the first word if the second
word is the first word in reverse order (case insensitive).
2. If the second word is the reversed version of the first word:
- Step 1: Reverse the first word.
- Step 2: Convert the reversed word to lowercase.
- Step 3: Replace all vowels (a, e, i, o, u) in the reversed word with the character
'@'.
- Step 4: Then, print the transformed word.
3. If the second word is not the reversed version of the first word:
- Step 1: Combine the first and second words into a single word (first word + second
word).
- Step 2: Convert the combined word to uppercase.
- Step 3: Count the number of vowels and consonants separately in the
uppercase word.
- Step 4: Based on the counts:
● If there are more vowels than consonants, print the first 2 vowels in the
uppercase word, removing any duplicates.
● If there are more consonants than vowels, print the first 2 consonants in
the uppercase word, removing any duplicates.
● If the vowel count equals consonant count, print "Vowels and consonants
are equal".
Validations:
- If the input words contain more than one word, print "<string> is an invalid word"
and terminate the program (Do not use System.exit(0)).
Note:

● In the Sample Input / Output provided, the highlighted text in bold corresponds
to the input given by the user and the rest of the text represents the output.
● Adhere to the code template, if provided.
● Please do not use System.exit(0) to terminate the program. */

import java.util.*;

public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        // Validation
        if (first.contains(" ")) {
            System.out.println(first + " is an invalid word");
            return;
        }
        if (second.contains(" ")) {
            System.out.println(second + " is an invalid word");
            return;
        }

        String reversed = new StringBuilder(first).reverse().toString();

        // Check If second is reverse of first or not (case-insensitive)
        if (reversed.equalsIgnoreCase(second)) {
            String result = reversed.toLowerCase().replaceAll("[aeiou]", "@");
            System.out.println(result);
        } else {
            String combined = (first + second).toUpperCase();

            int vowels = 0, consonants = 0;

            for (char ch : combined.toCharArray()) {
                if ("AEIOU".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }

            if (vowels > consonants) {
                printFirstTwo(combined, true);
            } else if (consonants > vowels) {
                printFirstTwo(combined, false);
            } else {
                System.out.println("Vowels and consonants are equal");
            }

        }

    }
// use LinkedHashSet to maintain order and duplication si not allowed so it will give first two unique vowels or consonants
    static void printFirstTwo(String str, boolean wantVowel) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            boolean isVowel = "AEIOU".indexOf(ch) != -1;

            if (wantVowel && isVowel)
                set.add(ch);
            else if (!wantVowel && !isVowel)
                set.add(ch);

            if (set.size() == 2)
                break;
        }

        for (char c : set)
            System.out.print(c);
    }
}
