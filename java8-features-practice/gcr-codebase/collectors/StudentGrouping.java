import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class StudentGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Rahul", "A"),
                new Student("Neha", "B"),
                new Student("Amit", "A"),
                new Student("Pooja", "B"),
                new Student("Ravi", "C")
        );

        Map<String, List<String>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println(result);
    }
}
