public class EmpWageApp {

    public void run() {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        IEmpWageBuilder builder = new EmpWageBuilder();
        builder.addCompany("DMart", 20, 20, 100);
        builder.addCompany("Reliance", 25, 22, 110);
        builder.addCompany("BigBazaar", 22, 18, 95);
        builder.computeWageForAllCompanies();
        System.out.println("\nTotal wage for each company:");
        for (CompanyEmpWage c : builder.getAllCompanies()) {
            System.out.println(c);
        }
    }
}
