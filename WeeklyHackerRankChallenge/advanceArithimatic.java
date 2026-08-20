

import java.io.*;
import java.util.*;

interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        AdvancedArithmetic calculator = new MyCalculator();

        System.out.println("I implemented: AdvancedArithmetic");
        System.out.println(calculator.divisor_sum(n));

        scanner.close();
    }
}