import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PolicyMapManager {
    private HashMap<String, Policy> hashMapPolicies;
    private LinkedHashMap<String, Policy> linkedHashMapPolicies;
    private TreeMap<LocalDate, Policy> treeMapPolicies;
    
    public PolicyMapManager() {
        this.hashMapPolicies = new HashMap<>();
        this.linkedHashMapPolicies = new LinkedHashMap<>();
        this.treeMapPolicies = new TreeMap<>();
    }
    
    public void addPolicyToHashMap(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
    }
    
    public void addPolicyToLinkedHashMap(Policy policy) {
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
    }
    
    public void addPolicyToTreeMap(Policy policy) {
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }
    
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }
    
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();
        
        for (Policy policy : hashMapPolicies.values()) {
            LocalDate expiryDate = policy.getExpiryDate();
            if (expiryDate.isAfter(today) && (expiryDate.isBefore(thirtyDaysLater) || expiryDate.isEqual(thirtyDaysLater))) {
                expiringSoon.add(policy);
            }
        }
        
        return expiringSoon;
    }
    
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }
    
    public void removeExpiredPolicies() {
        List<String> expiredPolicyNumbers = new ArrayList<>();
        
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.isExpired()) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }
        
        for (String policyNumber : expiredPolicyNumbers) {
            hashMapPolicies.remove(policyNumber);
            linkedHashMapPolicies.remove(policyNumber);
        }
        
        List<LocalDate> expiredDates = new ArrayList<>();
        for (Map.Entry<LocalDate, Policy> entry : treeMapPolicies.entrySet()) {
            if (entry.getValue().isExpired()) {
                expiredDates.add(entry.getKey());
            }
        }
        
        for (LocalDate date : expiredDates) {
            treeMapPolicies.remove(date);
        }
    }
    
    public void displayHashMapPolicies() {
        System.out.println("HashMap Policies:");
        for (Policy policy : hashMapPolicies.values()) {
            System.out.println(policy);
        }
    }
    
    public void displayLinkedHashMapPolicies() {
        System.out.println("LinkedHashMap Policies:");
        for (Policy policy : linkedHashMapPolicies.values()) {
            System.out.println(policy);
        }
    }
    
    public void displayTreeMapPolicies() {
        System.out.println("TreeMap Policies:");
        for (Policy policy : treeMapPolicies.values()) {
            System.out.println(policy);
        }
    }
}
