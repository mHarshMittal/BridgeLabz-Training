import java.util.Arrays;
import java.util.List;

public class CourseDemo {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("MTH101", new ExamCourse("Exam-Based"));
        Course<AssignmentCourse> prog = new Course<>("CSE201", new AssignmentCourse("Assignment-Based"));
        Course<ResearchCourse> thesis = new Course<>("RES501", new ResearchCourse("Research-Based"));

        List<? extends CourseType> list = Arrays.asList(
                math.getType(),
                prog.getType(),
                thesis.getType()
        );

        CourseView.printAll(list);
    }
}

