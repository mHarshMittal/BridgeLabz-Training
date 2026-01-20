import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ExamProctor {
    private final Stack<Integer> nav = new Stack<>();
    private final Map<Integer, String> ans = new HashMap<>();
    private final Map<Integer, String> key = new HashMap<>();

    public void visit(int qId) {
        nav.push(qId);
    }

    public void answer(int qId, String value) {
        ans.put(qId, value);
    }

    public void setCorrect(int qId, String value) {
        key.put(qId, value);
    }

    public void printNav() {
        System.out.println("Nav stack (top last): " + nav);
    }

    public int submit(ScoreFunc scorer) {
        return scorer.score(ans, key);
    }
}

