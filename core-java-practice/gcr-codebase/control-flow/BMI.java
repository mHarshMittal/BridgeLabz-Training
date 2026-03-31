import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double weight, heightCm, heightMtr, bmi;
        String status;

        weight = sc.nextDouble();
        heightCm = sc.nextDouble();

        heightMtr = heightCm / 100.0;
        bmi = weight / (heightMtr * heightMtr);

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("BMI = " + bmi);
        System.out.println("Status = " + status);
        sc.close();

    }
}
