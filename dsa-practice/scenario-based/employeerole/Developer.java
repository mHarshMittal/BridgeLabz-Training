
public class Developer extends Employee {
    private final double bonus;

    public Developer(String name, double salary) {
        super(name, salary);
        this.bonus = salary > 50_000 ? salary * 0.05 : 0.0;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}

