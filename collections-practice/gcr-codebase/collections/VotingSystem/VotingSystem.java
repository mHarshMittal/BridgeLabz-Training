import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {
    private HashMap<String, Integer> voteMap;
    private LinkedHashMap<String, Integer> voteOrderMap;
    
    public VotingSystem() {
        this.voteMap = new HashMap<>();
        this.voteOrderMap = new LinkedHashMap<>();
    }
    
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }
    
    public Map<String, Integer> getResultsSorted() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteMap);
        return sortedResults;
    }
    
    public LinkedHashMap<String, Integer> getResultsByOrder() {
        return new LinkedHashMap<>(voteOrderMap);
    }
    
    public HashMap<String, Integer> getAllVotes() {
        return new HashMap<>(voteMap);
    }
}
