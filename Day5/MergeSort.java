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
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {
    // Write your code here
    
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }
        
        int[] temp = new int[a.length];
        return mergeSort(a, temp, 0, a.length - 1);
    }
    
    private static long mergeSort(int[] a, int[] temp, int left, int right) {
        long invCount = 0;
        
        if (left < right) {
            int mid = (left + right) / 2;
            
            invCount += mergeSort(a, temp, left, mid);
            invCount += mergeSort(a, temp, mid + 1, right);
            invCount += merge(a, temp, left, mid, right);
        }
        
        return invCount;
    }
    
    private static long merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long invCount = 0;
        
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                invCount += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        
        while (j <= right) {
            temp[k++] = a[j++];
        }
        
        for (i = left; i <= right; i++) {
            a[i] = temp[i];
        }
        
        return invCount;
    }
        }
        

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                long result = Result.countInversions(arr);

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
