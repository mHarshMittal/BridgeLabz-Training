
class Student {
	public int rollNumber;
	protected String name;
	private double cgpa;

	Student(int rollNumber, String name, double cgpa) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.cgpa = cgpa;
	}

	public double getCGPA() {
		return cgpa;
	}

	public void setCGPA(double cgpa) {
		this.cgpa = cgpa;
	}
}

class PostGraduateStudent extends Student {
	public PostGraduateStudent(int rollNumber, String name, double cgpa) {
		
		super(rollNumber, name, cgpa);
	}

	void display() {
		System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", CGPA: " + getCGPA());
	}
}

public class UniversityManagementSystem {

	public static void main(String[] args) {
		PostGraduateStudent s1 = new PostGraduateStudent(1, "Govind", 3.5);
		s1.display();
		s1.setCGPA(9.3);
		s1.display();
	}

}
