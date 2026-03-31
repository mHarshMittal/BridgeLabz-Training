// Base class
class Employee {
    String name;
    int id;
    double sal;

    Employee(String name, int id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + sal);
    }
}

// Manager class
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double sal, int teamSize) {
        super(name, id, sal);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer class
class Developer extends Employee {
    String lang;

    Developer(String name, int id, double sal, String lang) {
        super(name, id, sal);
        this.lang = lang;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Language: " + lang);
    }
}

// Intern class
class Intern extends Employee {
    int duration;

    Intern(String name, int id, double sal, int duration) {
        super(name, id, sal);
        this.duration = duration;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Months: " + duration);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Manager("Amit", 1, 50000, 5);
        Employee e2 = new Developer("Neha", 2, 40000, "Java");
        Employee e3 = new Intern("Ravi", 3, 15000, 6);

        e1.displayDetails();
        System.out.println();

        e2.displayDetails();
        System.out.println();

        e3.displayDetails();
    }
}
