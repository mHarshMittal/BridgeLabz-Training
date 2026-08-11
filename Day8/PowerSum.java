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
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    public static int powerSum(int X, int N) {
    // Write your code here
    
    

        return countWays(X, N, 1);
    }

    private static int countWays(int remaining, int power, int num) {

        // Exact sum 
        if (remaining == 0) {
            return 1;
        }

        // No valid number left
        if (remaining < 0) {
            return 0;
        }

        int value = (int) Math.pow(num, power);

        // This number is already too large
        if (value > remaining) {
            return 0;
        }

        //  include num^power
        int include = countWays(remaining - value, power, num + 1);

        //  skip num^power
        int exclude = countWays(remaining, power, num + 1);

        return include + exclude;
    }
}

   

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
