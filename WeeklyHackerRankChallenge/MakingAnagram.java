import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
    // Write your code here
        int[] freq = new int[26];
        
        // Count chars in first str
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
        }
        
        // Subtract chars in second str
        for (int i = 0; i < b.length(); i++) {
            freq[b.charAt(i) - 'a']--;
        }
        
        // Total deletions required
        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(freq[i]);
        }
        
        return deletions;
    }
        }
        
        
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
