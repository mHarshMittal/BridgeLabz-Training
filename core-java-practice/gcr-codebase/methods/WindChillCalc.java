import java.util.*;
public class WindChillCalc {
    public static double calWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16)
               + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double temp = sc.nextDouble();
        System.out.print("Enter wind speed in mph: ");
        double windSpeed = sc.nextDouble();
        double windChill = calWindChill(temp, windSpeed);
        System.out.printf("Wind Chill Temperature: %.2f°F%n", windChill);
    }
}