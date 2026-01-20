
public abstract class Employee {
    private final String name;
    private final double salary;

    protected Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public final String getName() {
        return name;
    }

    public final double getSalary() {
        return salary;
    }

    public abstract double getBonus();
}

