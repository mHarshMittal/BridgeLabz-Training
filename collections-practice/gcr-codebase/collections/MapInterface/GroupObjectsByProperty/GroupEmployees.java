import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupEmployees {
    
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            
            if (!groupedMap.containsKey(department)) {
                groupedMap.put(department, new ArrayList<>());
            }
            
            groupedMap.get(department).add(employee);
        }
        
        return groupedMap;
    }
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        
        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
