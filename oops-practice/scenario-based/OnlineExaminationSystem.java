import java.util.*;

// Online exam system with evaluation strategies.
public class OnlineExaminationSystem {
    public static void main(String[] args) {
        EvaluationStrategy objective = new ObjectiveEvaluation();
        EvaluationStrategy descriptive = new DescriptiveEvaluation();

        Exam exam = new Exam("E1", objective);
        exam.addQuestion(new Question("Q1", "2+2?", "4"));
        exam.addQuestion(new Question("Q2", "Capital of India?", "Delhi"));

        ExamStudent student = new ExamStudent("S1", "Karan");
        Map<String, String> answers = new HashMap<>();
        answers.put("Q1", "4");
        answers.put("Q2", "Delhi");

        Result result = exam.submitAnswers(student, answers);
        System.out.println("Score: " + result.getScore());

        exam.setEvaluationStrategy(descriptive);
    Result descResult = exam.submitAnswers(student, answers);
        System.out.println("Desc Score: " + descResult.getScore());
    }
}

class ExamStudent {
    private final String id;
    private final String name;

    ExamStudent(String id, String name) {
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

class Question {
    private final String id;
    private final String text;
    private final String correctAnswer;

    Question(String id, String text, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getId() {
        return id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Exam {
    private final String id;
    private final List<Question> questions = new ArrayList<>();
    private EvaluationStrategy evaluationStrategy;

    Exam(String id, EvaluationStrategy evaluationStrategy) {
        this.id = id;
        this.evaluationStrategy = evaluationStrategy;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }

    Result submitAnswers(ExamStudent student, Map<String, String> answers) {
        int score = evaluationStrategy.evaluate(questions, answers);
        return new Result(student, id, score);
    }

    void setEvaluationStrategy(EvaluationStrategy evaluationStrategy) {
        this.evaluationStrategy = evaluationStrategy;
    }
}

interface EvaluationStrategy {
    int evaluate(List<Question> questions, Map<String, String> answers);
}

class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<Question> questions, Map<String, String> answers) {
        int score = 0;
        for (Question q : questions) {
            if (q.getCorrectAnswer().equalsIgnoreCase(answers.getOrDefault(q.getId(), ""))) {
                score += 1;
            }
        }
        return score;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<Question> questions, Map<String, String> answers) {
        // Lenient scoring for demonstration.
        return (int) Math.ceil(questions.size() * 0.8);
    }
}

class ExamTimeExpiredException extends RuntimeException {
    ExamTimeExpiredException(String msg) {
        super(msg);
    }
}

class Result {
    private final ExamStudent student;
    private final String examId;
    private final int score;

    Result(ExamStudent student, String examId, int score) {
        this.student = student;
        this.examId = examId;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

