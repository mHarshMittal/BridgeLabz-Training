public class EmpDetails {

    String name;
    int id;
    double salary;

    public EmpDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }
// main Mthod
    public static void main(String[] args) {
        EmpDetails emp = new EmpDetails("John Doe", 101, 55000);
        emp.displayDetails();
    }
}