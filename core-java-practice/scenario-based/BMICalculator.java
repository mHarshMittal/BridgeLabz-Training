import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get height and weight from the user
        System.out.println("Enter height in meters:");
        double h = input.nextDouble();

        System.out.println("Enter weight in kilograms:");
        double w = input.nextDouble();

        // Calculate BMI
        double bmi = w / (h * h);

        // Print BMI
        System.out.println("BMI: " + bmi);

        // Determine categoryjava 
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal";
        } else {
            category = "Overweight";
        }

        // Print category
        System.out.println("Category: " + category);

        input.close();
    }
}