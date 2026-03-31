import java.util.*;

// Simple online voting with duplicate vote prevention.
public class OnlineVotingSystem {
    public static void main(String[] args) {
        ElectionService service = new SimpleElectionService();
        service.registerVoter(new Voter("V1", "Aanya"));
        service.registerCandidate(new Candidate("C1", "Candidate One"));

        service.castVote("V1", "C1");
        System.out.println("Result: " + service.getResults());
    }
}

class Voter {
    private final String id;
    private final String name;

    Voter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}

class Candidate {
    private final String id;
    private final String name;

    Candidate(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Vote {
    private final String voterId;
    private final String candidateId;

    Vote(String voterId, String candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getVoterId() {
        return voterId;
    }
}

interface ElectionService {
    void registerVoter(Voter voter);
    void registerCandidate(Candidate candidate);
    void castVote(String voterId, String candidateId);
    Map<String, Long> getResults();
}

class DuplicateVoteException extends RuntimeException {
    DuplicateVoteException(String msg) {
        super(msg);
    }
}

class SimpleElectionService implements ElectionService {
    private final Map<String, Voter> voters = new HashMap<>();
    private final Map<String, Candidate> candidates = new HashMap<>();
    private final List<Vote> votes = new ArrayList<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.put(voter.getId(), voter);
    }

    @Override
    public void registerCandidate(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void castVote(String voterId, String candidateId) {
        if (votes.stream().anyMatch(v -> v.getVoterId().equals(voterId))) {
            throw new DuplicateVoteException("Voter already voted");
        }
        if (!candidates.containsKey(candidateId)) {
            throw new IllegalArgumentException("Candidate missing");
        }
        votes.add(new Vote(voterId, candidateId));
    }

    @Override
    public Map<String, Long> getResults() {
        Map<String, Long> result = new HashMap<>();
        for (Vote vote : votes) {
            result.merge(vote.getCandidateId(), 1L, Long::sum);
        }
        return result;
    }
}

