import java.util.ArrayList;
import java.util.List;

// exception
class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String m) {
        super(m);
    }
}

public class QuizProcessor {

    static List<Integer> scores = new ArrayList<>();

    static int getScore(String[] ca, String[] ua)
            throws InvalidQuizSubmissionException {

        if (ca.length != ua.length) {
            throw new InvalidQuizSubmissionException("Answer count mismatch");
        }

        int s = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i].equals(ua[i])) {
                s++;
            }
        }
        return s;
    }

    // return grade
    static String getGrade(int s) {
        if (s >= 4) return "A";
        if (s >= 2) return "B";
        return "Fail";
    }

    public static void main(String[] args) {
        String[] ca = {"A", "B", "C", "D"};
        String[] ua = {"A", "B", "A", "D"};

        try {
            int s = getScore(ca, ua);
            scores.add(s);

            System.out.println("Score: " + s);
            System.out.println("Grade: " + getGrade(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
