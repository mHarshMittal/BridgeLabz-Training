// Base class
class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }
}

// Teacher class
class Teacher extends Person {
    String subject;

    Teacher(String n, int a, String sub) {
        super(n, a);
        subject = sub;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
    }
}

// Student class
class Student extends Person {
    String grade;

    Student(String n, int a, String g) {
        super(n, a);
        grade = g;
    }

    void displayRole() {
        System.out.println("Role: Student");
    }
}

// Staff class
class Staff extends Person {
    String department;

    Staff(String n, int a, String dept) {
        super(n, a);
        department = dept;
    }

    void displayRole() {
        System.out.println("Role: Staff");
    }
}

// Test class
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Amit", 35, "Physics");
        Student s = new Student("Riya", 16, "10th");
        Staff st = new Staff("Suresh", 40, "Accounts");

        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
