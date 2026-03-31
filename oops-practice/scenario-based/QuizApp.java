public class QuizApp {

    public static void main(String[] args) {

        // correct answers
        String[] ca = {"A","B","C","D","A","B","C","D","A","B"};

        // student answers
        String[] sa = {"A","b","C","A","A","B","D","D","a","C"};

        int score = getScore(ca, sa);

        // feedback for each question
        for (int i = 0; i < ca.length; i++) {
            if (ca[i].equalsIgnoreCase(sa[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        // percentage calculation
        double per = score * 100.0 / ca.length;

        System.out.println("\nTotal Score: " + score);
        System.out.println("Percentage: " + per + "%");

        // pass or fail
        if (per >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }

    // method to calculate score
    static int getScore(String[] c, String[] s) {
        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i].equalsIgnoreCase(s[i])) {
                cnt++;
            }
        }
        return cnt;
    }
}
