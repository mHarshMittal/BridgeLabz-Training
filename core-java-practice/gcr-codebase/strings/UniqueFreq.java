import java.util.*;

class UniqueFreq {
    static char[] unique(String s) {
        char[] u = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean f = true;
            for (int j = 0; j < i; j++)
                if (s.charAt(i) == s.charAt(j)) f = false;
            if (f) u[k++] = s.charAt(i);
        }
        return Arrays.copyOf(u, k);
    }

    static void show(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        for (char c : unique(s))
            System.out.println(c + " " + f[c]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        show(sc.nextLine());
    }
}
