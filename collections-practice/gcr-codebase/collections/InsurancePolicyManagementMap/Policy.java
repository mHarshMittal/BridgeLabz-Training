import java.time.LocalDate;

public class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, 
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public String getPolicyholderName() {
        return policyholderName;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public String getCoverageType() {
        return coverageType;
    }
    
    public double getPremiumAmount() {
        return premiumAmount;
    }
    
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
    
    @Override
    public String toString() {
        return "Policy{policyNumber='" + policyNumber + "', policyholderName='" + 
               policyholderName + "', expiryDate=" + expiryDate + ", coverageType='" + 
               coverageType + "', premiumAmount=" + premiumAmount + "}";
    }
}
