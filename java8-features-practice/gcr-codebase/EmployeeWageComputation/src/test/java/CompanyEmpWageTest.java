import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompanyEmpWageTest {

    @Test
    public void constructorSetsFieldsAndTotalWageZero() {
        CompanyEmpWage company = new CompanyEmpWage("TestCo", 20, 20, 100);
        assertEquals("TestCo", company.getCompanyName());
        assertEquals(20, company.getWagePerHour());
        assertEquals(20, company.getMaxWorkingDays());
        assertEquals(100, company.getMaxHoursPerMonth());
        assertEquals(0, company.getTotalWage());
    }

    @Test
    public void setTotalWageUpdatesTotalWage() {
        CompanyEmpWage company = new CompanyEmpWage("ABC", 10, 5, 50);
        company.setTotalWage(500);
        assertEquals(500, company.getTotalWage());
    }

    @Test
    public void toStringContainsCompanyNameAndTotalWage() {
        CompanyEmpWage company = new CompanyEmpWage("DMart", 20, 20, 100);
        company.setTotalWage(2000);
        String s = company.toString();
        assertTrue(s.contains("DMart"));
        assertTrue(s.contains("2000"));
    }
}
