import java.io.*;
import java.util.*;

public class Solution {
    
    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        
        int pivot = arr.get(0);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int x : arr) {
            if (x < pivot) {
                left.add(x);
            } else if (x == pivot) {
                equal.add(x);
            } else {
                right.add(x);
            }
        }
        
        left = quickSort(left);
        right = quickSort(right);
        
        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);
        
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        quickSort(arr);
    }
}