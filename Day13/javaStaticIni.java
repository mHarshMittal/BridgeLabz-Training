import java.io.*;
import java.util.*;

public class Solution {
    
    static int b, h;
    static{
        Scanner s = new Scanner(System.in);
        b = s.nextInt();
        h = s.nextInt();
        if(b<=0 || h<=0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
    


    public static void main(String[] args) {
        if(b>0 && h>0){
            System.out.println(b*h);
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}