import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "John Doe", "IT", 75000));
        employees.add(new Employee(102, "Jane Smith", "HR", 65000));
        employees.add(new Employee(103, "Bob Johnson", "Finance", 80000));
        
        String filename = "employees.dat";
        
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
            fos.close();
            
            System.out.println("Employees saved to file.");
            
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Employee> retrievedEmployees = (List<Employee>) ois.readObject();
            ois.close();
            fis.close();
            
            System.out.println("\nRetrieved Employees:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
            
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
