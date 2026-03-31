import java.util.*;

class BMI {
    static String[][] calculate(double[][] data) {
        String[][] res = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double w = data[i][0];
            double h = data[i][1] / 100.0;
            double bmi = w / (h * h);
            String s = bmi < 18.5 ? "Underweight" : bmi < 25 ? "Normal" : bmi < 30 ? "Overweight" : "Obese";
            res[i][0] = "" + data[i][1];
            res[i][1] = "" + w;
            res[i][2] = String.format("%.2f", bmi);
            res[i][3] = s;
        }
        return res;
    }

    static void display(String[][] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2] + " " + a[i][3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] d = new double[10][2];
        for (int i = 0; i < 10; i++) {
            d[i][0] = sc.nextDouble();
            d[i][1] = sc.nextDouble();
        }
        display(calculate(d));
        sc.close();
    }
}
