import java.util.*;

class NestedFreq {
    static String[] freq(String s) {
        char[] a = s.toCharArray();
        int[] f = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '0') continue;
            f[i] = 1;
            for (int j = i + 1; j < a.length; j++)
                if (a[i] == a[j]) { f[i]++; a[j] = '0'; }
        }
        String[] r = new String[a.length];
        int k = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != '0') r[k++] = a[i] + " " + f[i];
        return Arrays.copyOf(r, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (String x : freq(sc.nextLine())) System.out.println(x);
        sc.close();
    }
}
