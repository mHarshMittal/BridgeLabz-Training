import java.time.LocalDate;

public class PolicyMapManagerDemo {
    public static void main(String[] args) {
        PolicyMapManager manager = new PolicyMapManager();
        
        Policy policy1 = new Policy("POL001", "Rajesh Kumar", 
                                    LocalDate.of(2024, 12, 31), "Health", 5000.0);
        Policy policy2 = new Policy("POL002", "Priya Sharma", 
                                    LocalDate.of(2024, 11, 15), "Auto", 8000.0);
        Policy policy3 = new Policy("POL003", "Amit Patel", 
                                    LocalDate.of(2025, 1, 20), "Home", 12000.0);
        
        manager.addPolicyToHashMap(policy1);
        manager.addPolicyToHashMap(policy2);
        manager.addPolicyToHashMap(policy3);
        
        manager.addPolicyToLinkedHashMap(policy1);
        manager.addPolicyToLinkedHashMap(policy2);
        manager.addPolicyToLinkedHashMap(policy3);
        
        manager.addPolicyToTreeMap(policy1);
        manager.addPolicyToTreeMap(policy2);
        manager.addPolicyToTreeMap(policy3);
        
        System.out.println("=== Retrieve Policy by Number ===");
        Policy found = manager.getPolicyByNumber("POL001");
        System.out.println(found);
        
        System.out.println("\n=== Policies Expiring Soon ===");
        var expiringSoon = manager.getPoliciesExpiringSoon();
        for (Policy policy : expiringSoon) {
            System.out.println(policy);
        }
        
        System.out.println("\n=== Policies for Rajesh Kumar ===");
        var policies = manager.getPoliciesByPolicyholder("Rajesh Kumar");
        for (Policy policy : policies) {
            System.out.println(policy);
        }
        
        System.out.println("\n=== LinkedHashMap (Insertion Order) ===");
        manager.displayLinkedHashMapPolicies();
        
        System.out.println("\n=== TreeMap (Sorted by Expiry Date) ===");
        manager.displayTreeMapPolicies();
    }
}
