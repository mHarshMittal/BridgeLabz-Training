/*Employee Management System
Description: Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference.*/

// Interface for department related work
interface Department {
    void assignDepartment(String deptName);

    String getDepartmentDetails();
}

// Abstract class Employee
abstract class Employee {

    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee implements Department {

    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    // Fixed salary
    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// Part Time Employee
class PartTimeEmployee extends Employee implements Department {

    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Salary based on hours
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Polymorphism
        Employee e1 = new FullTimeEmployee(1, "Rahul", 45000);
        Employee e2 = new PartTimeEmployee(2, "Pooja", 60, 300);

        // Assign departments
        ((Department) e1).assignDepartment("IT");
        ((Department) e2).assignDepartment("HR");

        // Employee list
        Employee[] employees = { e1, e2 };

        // Process employees
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println("------------------------");
        }
    }
}
