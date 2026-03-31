/*StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates */

import java.util.*;
public class RemoveDupicate{
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        
        String input = "Harsh Mittal";
        String output = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + output);
    }
}
