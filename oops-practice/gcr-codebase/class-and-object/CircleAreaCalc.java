public class CircleAreaCalc {
    double radius;

    // Constructor for radius
    public CircleAreaCalc(double radius) {
        this.radius = radius;
    }

    // Method for  calculating the  area of circle
    public double calArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference of circle 
    public double calculateCircum() {
        return 2 * Math.PI * radius;
    }

    // Method to display radius, area and circumference
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calArea());
        System.out.println("Circumference: " + calculateCircum());
    }

    // Main method
    public static void main(String[] args) {
        CircleAreaCalc circle = new CircleAreaCalc(5);
        circle.display();
    }
}