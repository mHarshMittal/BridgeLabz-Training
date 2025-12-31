class Circle {
    private double radius;
    Circle() {
        this(1.0);
    }
    Circle(double radius) {
        this.radius = radius;
    }
    void display() {
    	System.out.println("Radius is " + radius);
    }
}

public class CircleDet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle();
		Circle c2 = new Circle(5.6);
		c1.display();
		c2.display();
	}

}