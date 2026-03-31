import java.util.*;

class UniqueChars {
    static int len(String s) {
        int i = 0;
        try { while (true) s.charAt(i++); }
        catch (Exception e) {}
        return i - 1;
    }

    static char[] unique(String s) {
        int n = len(s);
        char[] r = new char[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean f = true;
            for (int j = 0; j < i; j++)
                if (c == s.charAt(j)) f = false;
            if (f) r[k++] = c;
        }
        return Arrays.copyOf(r, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] u = unique(sc.nextLine());
        for (char c : u) System.out.print(c + " ");
    }
}
