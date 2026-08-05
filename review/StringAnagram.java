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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
    
    // if string odd not possible 
    int n = s.length()/2;
    if (s.length()%2 !=0){
        return -1;
    }
    String x = s.substring(0,n);
    String y = s.substring(n);
    
    int [] c = new int[26];
    
    for (int i =0; i<n; i++){
        c[x.charAt(i) - 'a']++;
       // to find no of char in first sub string 
        
    }
    
    for (int i =0; i<n; i++){
        c[y.charAt(i)- 'a']--;
        // to find no of char in second substring 
        
    }
    
    int res = 0;
    for(int i=0; i<26; i++){
        if (c[i]>0){
            res += c[i];
        }
    }
    return res;
    
    
    


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
