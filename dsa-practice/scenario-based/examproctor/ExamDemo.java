public class ExamDemo {
    public static void main(String[] args) {
        ExamProctor ep = new ExamProctor();

        ep.visit(1);
        ep.visit(2);
        ep.visit(3);
        ep.printNav();

        ep.setCorrect(1, "A");
        ep.setCorrect(2, "B");
        ep.setCorrect(3, "C");

        ep.answer(1, "A");
        ep.answer(2, "C");
        ep.answer(3, "C");

        ScoreFunc scorer = (answers, key) -> {
            int score = 0;
            for (Integer q : answers.keySet()) {
                String a = answers.get(q);
                String k = key.get(q);
                if (k != null && a != null && k.equalsIgnoreCase(a)) score++;
            }
            return score;
        };

        int score = ep.submit(scorer);
        System.out.println("Score: " + score);
    }
}

