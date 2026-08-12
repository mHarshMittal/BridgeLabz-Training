import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for(int i =0; i< arr.length; i++){
            if(arr[i] == i+1){
                continue;
        // Above we are checking if element is at correct position as per the index then we will continue without making any swap 
            }
            
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] == i+1){
                    int temp =  arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swaps++;
                    break;  
                    // swaps elements till they match with the index 
                }
            }
           
            
            
            
        }
         return swaps;
        


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
