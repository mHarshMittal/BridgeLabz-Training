import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class EmpWageBuilderTest {

    private EmpWageBuilder builder;

    @Before
    public void setUp() {
        builder = new EmpWageBuilder();
    }

    @Test
    public void isValidCompanyNameAcceptsAlphanumericAndSpaces() {
        assertTrue(EmpWageBuilder.isValidCompanyName("DMart"));
        assertTrue(EmpWageBuilder.isValidCompanyName("Reliance 2"));
        assertTrue(EmpWageBuilder.isValidCompanyName("BigBazaar"));
        assertTrue(EmpWageBuilder.isValidCompanyName("Co123"));
    }

    @Test
    public void isValidCompanyNameRejectsNullAndBlank() {
        assertFalse(EmpWageBuilder.isValidCompanyName(null));
        assertFalse(EmpWageBuilder.isValidCompanyName(""));
        assertFalse(EmpWageBuilder.isValidCompanyName("   "));
    }

    @Test
    public void isValidCompanyNameRejectsInvalidCharacters() {
        assertFalse(EmpWageBuilder.isValidCompanyName("@DMart"));
        assertFalse(EmpWageBuilder.isValidCompanyName("DMart!"));
        assertFalse(EmpWageBuilder.isValidCompanyName("D-Mart"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCompanyThrowsWhenCompanyNameInvalid() {
        builder.addCompany("Invalid@Name", 20, 20, 100);
    }

    @Test
    public void addCompanyTrimsWhitespaceAndAcceptsValidName() {
        builder.addCompany("  DMart  ", 20, 20, 100);
        List<CompanyEmpWage> all = builder.getAllCompanies();
        assertEquals(1, all.size());
        assertEquals("DMart", all.get(0).getCompanyName());
    }

    @Test
    public void computeWageForAllCompaniesProducesNonNegativeTotal() {
        builder.addCompany("TestCo", 20, 20, 100);
        builder.computeWageForAllCompanies();
        Integer wage = builder.getTotalWageByCompany("TestCo");
        assertNotNull(wage);
        assertTrue(wage >= 0);
    }

    @Test
    public void computeWageWithFixedRandomIsDeterministic() {
        Random fixedRandom = new Random(42);
        EmpWageBuilder b1 = new EmpWageBuilder(fixedRandom);
        b1.addCompany("DeterministicCo", 10, 5, 30);
        b1.computeWageForAllCompanies();
        Integer wage1 = b1.getTotalWageByCompany("DeterministicCo");

        fixedRandom = new Random(42);
        EmpWageBuilder b2 = new EmpWageBuilder(fixedRandom);
        b2.addCompany("DeterministicCo", 10, 5, 30);
        b2.computeWageForAllCompanies();
        Integer wage2 = b2.getTotalWageByCompany("DeterministicCo");

        assertEquals(wage1, wage2);
    }

    @Test
    public void getTotalWageByCompanyReturnsNullForUnknownCompany() {
        builder.addCompany("DMart", 20, 20, 100);
        assertNull(builder.getTotalWageByCompany("Unknown"));
    }

    @Test
    public void getTotalWageByCompanyReturnsNullForNullInput() {
        assertNull(builder.getTotalWageByCompany(null));
    }
}
