/*StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate all the strings in the array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.
 */

import java.util.*;
public class StringConcatenation {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!", " Welcome", " to", " StringBuffer."};
        String result = concatenateStrings(strings);
        System.out.println(result);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}