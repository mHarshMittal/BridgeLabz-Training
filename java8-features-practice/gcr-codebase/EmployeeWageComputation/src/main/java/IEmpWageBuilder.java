import java.util.List;

public interface IEmpWageBuilder {

    void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxHoursPerMonth);

    void computeWageForAllCompanies();

    Integer getTotalWageByCompany(String companyName);

    List<CompanyEmpWage> getAllCompanies();
}
