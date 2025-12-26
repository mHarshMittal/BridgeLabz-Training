import java.util.*;

class CalendarApp {
    static boolean leap(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    static int firstDay(int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (1 + x + 31*m0/12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), y = sc.nextInt();
        int[] d = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m == 2 && leap(y)) d[1] = 29;
        int fd = firstDay(m,y);
        for (int i = 0; i < fd; i++) System.out.print("   ");
        for (int i = 1; i <= d[m-1]; i++) {
            System.out.printf("%3d", i);
            if ((i + fd) % 7 == 0) System.out.println();
            sc.close();
        }
    }
}
