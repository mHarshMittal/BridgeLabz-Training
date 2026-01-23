import java.time.LocalDate;

public class PolicyManagerDemo {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        
        Policy policy1 = new Policy("POL001", "Rajesh Kumar", 
                                    LocalDate.of(2024, 12, 31), "Health", 5000.0);
        Policy policy2 = new Policy("POL002", "Priya Sharma", 
                                    LocalDate.of(2024, 11, 15), "Auto", 8000.0);
        Policy policy3 = new Policy("POL003", "Amit Patel", 
                                    LocalDate.of(2025, 1, 20), "Home", 12000.0);
        
        manager.addPolicyToHashSet(policy1);
        manager.addPolicyToHashSet(policy2);
        manager.addPolicyToHashSet(policy3);
        
        manager.addPolicyToLinkedHashSet(policy1);
        manager.addPolicyToLinkedHashSet(policy2);
        manager.addPolicyToLinkedHashSet(policy3);
        
        manager.addPolicyToTreeSet(policy1);
        manager.addPolicyToTreeSet(policy2);
        manager.addPolicyToTreeSet(policy3);
        
        System.out.println("=== All Unique Policies ===");
        manager.displayHashSetPolicies();
        
        System.out.println("\n=== Policies Expiring Soon ===");
        var expiringSoon = manager.getPoliciesExpiringSoon();
        for (Policy policy : expiringSoon) {
            System.out.println(policy);
        }
        
        System.out.println("\n=== Health Policies ===");
        var healthPolicies = manager.getPoliciesByCoverageType("Health");
        for (Policy policy : healthPolicies) {
            System.out.println(policy);
        }
        
        System.out.println("\n=== LinkedHashSet (Insertion Order) ===");
        manager.displayLinkedHashSetPolicies();
        
        System.out.println("\n=== TreeSet (Sorted by Expiry Date) ===");
        manager.displayTreeSetPolicies();
        
        System.out.println("\n=== Performance Comparison ===");
        Policy testPolicy = new Policy("POL006", "Test User", 
                                       LocalDate.now().plusDays(60), "Health", 5000.0);
        
        long hashSetTime = manager.measureAddTimeHashSet(testPolicy);
        long linkedHashSetTime = manager.measureAddTimeLinkedHashSet(testPolicy);
        long treeSetTime = manager.measureAddTimeTreeSet(testPolicy);
        
        System.out.println("Add - HashSet: " + hashSetTime + " ns");
        System.out.println("Add - LinkedHashSet: " + linkedHashSetTime + " ns");
        System.out.println("Add - TreeSet: " + treeSetTime + " ns");
    }
}
