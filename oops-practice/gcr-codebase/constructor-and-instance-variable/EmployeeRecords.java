class Employee{
	public int employeeId;
	protected String department;
	private double salary;
	Employee(int employeeId, String department, double salary){
		this.department = department;
		this.employeeId = employeeId;
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
class Manager extends Employee{
	Manager(int employeeId, String department, double salary){
		super(employeeId, department, salary);
	}
	void display() {
		System.out.println("Employee ID: " + employeeId);
		System.out.println("Department: " + department);
	}
}
public class EmployeeRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m1 = new Manager(100, "Sales", 100000);
		m1.display();
		System.out.println("Salary: " + m1.getSalary());
		m1.setSalary(200000);
		System.out.println("Updated Salary: " + m1.getSalary());
	}

}
