public class StudentReports {
    String name;
    int rollNum;
    int marks;

    // Constructor to initialize student attributes
    public StudentReports(String name, int rollNum, int marks) {
        this.name = name;
        this.rollNum = rollNum;
        this.marks = marks;
    }

    // Method to calculate marks and grades of students
    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    // Method to display student details and grade
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNum);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    // Main method
    public static void main(String[] args) {
        StudentReports student = new StudentReports("Alice", 101, 82);
        student.displayDetails();
    }
}