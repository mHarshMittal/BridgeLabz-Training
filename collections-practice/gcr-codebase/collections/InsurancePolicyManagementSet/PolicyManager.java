import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class PolicyManager {
    private HashSet<Policy> hashSetPolicies;
    private LinkedHashSet<Policy> linkedHashSetPolicies;
    private TreeSet<Policy> treeSetPolicies;
    
    public PolicyManager() {
        this.hashSetPolicies = new HashSet<>();
        this.linkedHashSetPolicies = new LinkedHashSet<>();
        this.treeSetPolicies = new TreeSet<>(new PolicyComparator());
    }
    
    public void addPolicyToHashSet(Policy policy) {
        hashSetPolicies.add(policy);
    }
    
    public void addPolicyToLinkedHashSet(Policy policy) {
        linkedHashSetPolicies.add(policy);
    }
    
    public void addPolicyToTreeSet(Policy policy) {
        treeSetPolicies.add(policy);
    }
    
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }
    
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();
        
        for (Policy policy : hashSetPolicies) {
            LocalDate expiryDate = policy.getExpiryDate();
            if (expiryDate.isAfter(today) && (expiryDate.isBefore(thirtyDaysLater) || expiryDate.isEqual(thirtyDaysLater))) {
                expiringSoon.add(policy);
            }
        }
        
        return expiringSoon;
    }
    
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }
    
    public List<String> findDuplicatePolicyNumbers() {
        Set<String> seen = new HashSet<>();
        List<String> duplicates = new ArrayList<>();
        
        for (Policy policy : hashSetPolicies) {
            String policyNumber = policy.getPolicyNumber();
            if (seen.contains(policyNumber)) {
                duplicates.add(policyNumber);
            } else {
                seen.add(policyNumber);
            }
        }
        
        return duplicates;
    }
    
    public void displayHashSetPolicies() {
        System.out.println("HashSet Policies:");
        for (Policy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }
    
    public void displayLinkedHashSetPolicies() {
        System.out.println("LinkedHashSet Policies:");
        for (Policy policy : linkedHashSetPolicies) {
            System.out.println(policy);
        }
    }
    
    public void displayTreeSetPolicies() {
        System.out.println("TreeSet Policies:");
        for (Policy policy : treeSetPolicies) {
            System.out.println(policy);
        }
    }
    
    public long measureAddTimeHashSet(Policy policy) {
        long startTime = System.nanoTime();
        hashSetPolicies.add(policy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public long measureAddTimeLinkedHashSet(Policy policy) {
        long startTime = System.nanoTime();
        linkedHashSetPolicies.add(policy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public long measureAddTimeTreeSet(Policy policy) {
        long startTime = System.nanoTime();
        treeSetPolicies.add(policy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public long measureSearchTimeHashSet(String policyNumber) {
        long startTime = System.nanoTime();
        for (Policy policy : hashSetPolicies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public long measureSearchTimeLinkedHashSet(String policyNumber) {
        long startTime = System.nanoTime();
        for (Policy policy : linkedHashSetPolicies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public long measureSearchTimeTreeSet(String policyNumber) {
        long startTime = System.nanoTime();
        for (Policy policy : treeSetPolicies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
