class Student {

    String name;
    int age;
    String course;

    // No-argument constructor
    Student() {
        this("Unknown", 0, "Not assigned");
    }

    // Name-only constructor
    Student(String name) {
        this(name, 18, "General Studies");
    }

    // Full constructor
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println();
    }
}

public class consOverl {

    public static void main(String[] args) {

        // Using no-argument constructor
        Student student1 = new Student();

        // Using name-only constructor
        Student student2 = new Student("Harsh");

        // Using full constructor
        Student student3 = new Student("Rahul", 21, "Computer Science");

        // Print all students
        System.out.println("Student 1:");
        student1.display();

        System.out.println("Student 2:");
        student2.display();

        System.out.println("Student 3:");
        student3.display();
    }
}