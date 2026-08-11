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
    public static int stepPerms(int n) {
    // Write your code here
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        
        return (int) countWays(n, memo);
    }
 
    static long countWays(int n, long[] memo) {
        if (n == 0) {
            return 1;
            }
            
            if (n < 0) {
                return 0;
            }
            
            if (memo[n] != -1) {
                return memo[n];
            }
            
            long MOD = 10000000007L;
            
            memo[n] = (countWays(n - 1, memo)
            + countWays(n - 2, memo)
            + countWays(n - 3, memo)) % MOD;
            
            return memo[n];
    }
            }
            

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, s).forEach(sItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int res = Result.stepPerms(n);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
