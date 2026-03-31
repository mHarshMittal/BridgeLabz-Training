import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class EmpWageBuilder implements IEmpWageBuilder {

    private static final String COMPANY_NAME_REGEX = "^[A-Za-z0-9][A-Za-z0-9\\s]{0,49}$";
    private static final Pattern COMPANY_NAME_PATTERN = Pattern.compile(COMPANY_NAME_REGEX);
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    private final ArrayList<CompanyEmpWage> companyWageList;
    private final Random random;

    public EmpWageBuilder() {
        this(new Random());
    }

    public EmpWageBuilder(Random random) {
        this.companyWageList = new ArrayList<>();
        this.random = random;
    }

    public static boolean isValidCompanyName(String companyName) {
        if (companyName == null || companyName.isBlank()) return false;
        return COMPANY_NAME_PATTERN.matcher(companyName.trim()).matches();
    }

    public void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxHoursPerMonth) {
        if (!isValidCompanyName(companyName)) {
            throw new IllegalArgumentException("Invalid company name. Use only letters, numbers and spaces (1-50 chars).");
        }
        companyWageList.add(new CompanyEmpWage(companyName.trim(), wagePerHour, maxWorkingDays, maxHoursPerMonth));
    }

    public void computeWageForAllCompanies() {
        for (CompanyEmpWage company : companyWageList) {
            company.setTotalWage(computeEmployeeWage(company));
        }
    }

    private int computeEmployeeWage(CompanyEmpWage company) {
        int totalWage = 0;
        int totalHours = 0;
        int totalDays = 0;
        while (totalHours < company.getMaxHoursPerMonth() && totalDays < company.getMaxWorkingDays()) {
            totalDays++;
            int attendance = random.nextInt(3);
            int hoursWorked = 0;
            switch (attendance) {
                case 1:
                    hoursWorked = PART_TIME_HOUR;
                    break;
                case 2:
                    hoursWorked = FULL_DAY_HOUR;
                    break;
                default:
                    hoursWorked = 0;
            }
            totalHours += hoursWorked;
            if (totalHours > company.getMaxHoursPerMonth()) {
                totalHours -= hoursWorked;
                break;
            }
            totalWage += hoursWorked * company.getWagePerHour();
        }
        return totalWage;
    }

    public Integer getTotalWageByCompany(String companyName) {
        if (companyName == null) return null;
        for (CompanyEmpWage c : companyWageList) {
            if (companyName.equals(c.getCompanyName())) return c.getTotalWage();
        }
        return null;
    }

    public List<CompanyEmpWage> getAllCompanies() {
        return new ArrayList<>(companyWageList);
    }
}
