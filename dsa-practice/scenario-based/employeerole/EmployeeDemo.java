public class EmployeeDemo {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 80_000);
        System.out.printf("%.2f%n", manager.getBonus()); // 8000.00

        Employee dev1 = new Developer("Bob", 60_000);
        System.out.printf("Developer 60000 -> %.2f%n", dev1.getBonus()); // 3000.00

        Employee dev2 = new Developer("Cara", 40_000);
        System.out.printf("Developer 40000 -> %.2f%n", dev2.getBonus()); // 0.00
    }
}

