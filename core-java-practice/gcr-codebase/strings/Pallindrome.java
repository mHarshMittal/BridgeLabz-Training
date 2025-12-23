import java.util.*;

class Palindrome {
    static boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    static boolean rec(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return rec(s, i + 1, j - 1);
    }

    static boolean arr(String s) {
        char[] a = s.toCharArray();
        char[] r = new char[a.length];
        for (int i = 0; i < a.length; i++) r[i] = a[a.length - 1 - i];
        return Arrays.equals(a, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check(s));
        System.out.println(rec(s,0,s.length()-1));
        System.out.println(arr(s));
    }
}
