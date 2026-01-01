/*Create a program that analyzes a given paragraph of text. Implement the following
functionalities:
● Count the number of words in the paragraph.
● Find and display the longest word.
● Replace all occurrences of a specific word with another word (case-insensitive).
● Handle edge cases like empty strings or paragraphs with only spaces. */

import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter paragraph:");
        String p = sc.nextLine();

        if (p == null || p.trim().isEmpty()) {
            System.out.println("Paragraph is empty.");
            return;
        }

        // normalize spaces
        String txt = p.trim().replaceAll("\\s+", " ");
        String[] w = txt.split(" ");

        // word count
        int wc = w.length;

        // longest word
        String lw = w[0];
        for (String s : w)
            if (s.length() > lw.length())
                lw = s;

        // replace word (case-insensitive)
        System.out.print("Word to replace: ");
        String oldW = sc.nextLine();

        System.out.print("Replace with: ");
        String newW = sc.nextLine();

        String rep = txt.replaceAll("(?i)\\b" + oldW + "\\b", newW);

        // output
        System.out.println("\nWord Count: " + wc);
        System.out.println("Longest Word: " + lw);
        System.out.println("Updated Paragraph:");
        System.out.println(rep);

        sc.close();
    }
}
