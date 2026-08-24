import java.io.*;
import java.util.*;

class MyRegex {
    String pattern = "(([0-9]|[0-9]{2}|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[0-9]{2}|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])";
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyRegex myRegex = new MyRegex();

        while (sc.hasNextLine()) {
            String ip = sc.nextLine();
            System.out.println(ip.matches(myRegex.pattern));
        }

        sc.close();
    }
}