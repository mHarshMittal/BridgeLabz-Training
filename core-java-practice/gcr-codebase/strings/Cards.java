import java.util.*;

class Cards {
    static String[] init() {
        String[] s = {"Hearts","Diamonds","Clubs","Spades"};
        String[] r = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] d = new String[s.length * r.length];
        int k = 0;
        for (String x : s)
            for (String y : r)
                d[k++] = y + " of " + x;
        return d;
    }

    static void shuffle(String[] d) {
        for (int i = 0; i < d.length; i++) {
            int r = i + (int)(Math.random() * (d.length - i));
            String t = d[i]; d[i] = d[r]; d[r] = t;
        }
    }

    static String[][] deal(String[] d, int p, int n) {
        String[][] a = new String[p][n];
        int k = 0;
        for (int i = 0; i < p; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = d[k++];
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), n = sc.nextInt();
        String[] d = init();
        shuffle(d);
        String[][] a = deal(d,p,n);
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++)
                System.out.println(a[i][j]);
            System.out.println();
        }
    }
}
