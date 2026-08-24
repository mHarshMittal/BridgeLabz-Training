import java.io.*;
import java.util.*;

public class Solution {
    
    static int b, h;
    static boolean flag = true;
    
    static {
        Scanner s = new Scanner(System.in);
        b = s.nextInt();
        h = s.nextInt();
        
        if (b <= 0 || h <= 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            System.out.println(b * h);
        }
    }
}