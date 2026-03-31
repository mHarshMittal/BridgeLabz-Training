import java.util.Map;

public class VotingDemo {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        
        votingSystem.castVote("Candidate A");
        votingSystem.castVote("Candidate B");
        votingSystem.castVote("Candidate A");
        votingSystem.castVote("Candidate C");
        votingSystem.castVote("Candidate B");
        
        System.out.println("=== All Votes (HashMap) ===");
        Map<String, Integer> allVotes = votingSystem.getAllVotes();
        System.out.println(allVotes);
        
        System.out.println("\n=== Results Sorted (TreeMap) ===");
        Map<String, Integer> sortedResults = votingSystem.getResultsSorted();
        System.out.println(sortedResults);
        
        System.out.println("\n=== Results by Order (LinkedHashMap) ===");
        Map<String, Integer> orderResults = votingSystem.getResultsByOrder();
        System.out.println(orderResults);
    }
}
