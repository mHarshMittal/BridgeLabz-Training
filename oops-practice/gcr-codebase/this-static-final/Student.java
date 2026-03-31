public class Student {
    // Static variable shared across all students
    private static String univName = "GLA University";
    private static int totalStud = 0;
    
    private final int rollNum;
    private String name;
    private String grade;
    
    public Student(String name, int rollNum, String grade) {
        this.name = name;
        this.rollNum = rollNum; // Final variable assigned only once
        this.grade = grade;
        totalStud++; // Increment total students with each new student
    }
    
    public static void displayTotalStud() {
        System.out.println("Total Students Enrolled: " + totalStud);
    }
    
    // Method to display student details
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + univName);
            System.out.println("Roll Number: " + rollNum);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student instance.");
        }
    }
    
    // Method to update grade
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        } else {
            System.out.println("Invalid student instance.");
        }
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getRollNum() {
        return rollNum;
    }
    
    public String getGrade() {
        return grade;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create two students
        Student stu1 = new Student("Harsh", 101, "A");
        Student stu2 = new Student("Agraj", 102, "B");
        
        // Display total students
        displayTotalStud();
        
        // Display student details
        System.out.println();
        stu1.displayStudentDetails();
        System.out.println();
        stu2.displayStudentDetails();
        
        // Update grade
        System.out.println();
        stu2.updateGrade("A");
        System.out.println();
        stu2.displayStudentDetails();
    }
}

