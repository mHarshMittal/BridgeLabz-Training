
public class Employee {
    // Static variable shared across all employees
    private static String companyName = "M_Harsh Inc.";
    private static int totalEmpl = 0;
    
    private final int id;
    private String name;
    private String designation;
        public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id; 
        this.designation = designation;
        totalEmpl++; 
    }
    
    // Static method to display total number of employees
    public static void displayTotalEmpl() {
        System.out.println("Total Employees: " + totalEmpl);
    }
    
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee instance.");
        }
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create two employees
        Employee emp1 = new Employee("Agraj", 101, "Software Engineer");
        Employee emp2 = new Employee("Harsh", 102, "Project Manager");
        
        // Display total employees
        displayTotalEmpl();
        
        // Display employee details
        System.out.println();
        emp1.displayEmployeeDetails();
        System.out.println();
        emp2.displayEmployeeDetails();
    }
}

