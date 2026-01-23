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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
    
    @Override
    public String toString() {
        return "Policy{policyNumber='" + policyNumber + "', policyholderName='" + 
               policyholderName + "', expiryDate=" + expiryDate + ", coverageType='" + 
               coverageType + "', premiumAmount=" + premiumAmount + "}";
    }
}
