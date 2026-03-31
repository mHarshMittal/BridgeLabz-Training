import java.util.Scanner;

public class BMI {

    public static double calBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight(kg) of person " + (i + 1) + ": ");
            double weight = sc.nextDouble();
            System.out.print("Enter height(cm) of person " + (i + 1) + ": ");
            double height = sc.nextDouble();
            double bmi = calBMI(weight, height);
            System.out.printf("BMI: %.2f, Status: %s%n", bmi, getStatus(bmi));
            sc.close();
        }
    }
}