
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineCourseManager {

    public static void main(String[] args) {

        List<Enrollment> enrollments = Arrays.asList(
                new Enrollment("Rahul", "Java", "Programming", LocalDate.of(2026, 2, 10)),
                new Enrollment("Amit", "Python", "Programming", LocalDate.of(2026, 2, 5)),
                new Enrollment("Neha", "Digital Marketing", "Marketing", LocalDate.of(2026, 2, 8)),
                new Enrollment("Priya", "Java", "Programming", LocalDate.of(2026, 2, 3)),
                new Enrollment("Karan", "SEO", "Marketing", LocalDate.of(2026, 2, 6))
        );

        //Filter by specific course (Java)
        System.out.println("Filter by course: Java");
        enrollments.stream()
                .filter(e -> e.getCourseName().equalsIgnoreCase("Java"))
                .forEach(System.out::println);

        //Filter by category (Programming)
        System.out.println("\nFilter by category: Programming");
        enrollments.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase("Programming"))
                .forEach(System.out::println);

        //Group by course name
        System.out.println("\nGroup by course name");
        Map<String, List<Enrollment>> groupedByCourse =
                enrollments.stream()
                        .collect(Collectors.groupingBy(Enrollment::getCourseName));

        groupedByCourse.forEach((course, list) -> {
            System.out.println(course + " -> " + list);
        });

        //Count enrollments per category
        System.out.println("\nCount enrollments per category");
        Map<String, Long> countByCategory =
                enrollments.stream()
                        .collect(Collectors.groupingBy(Enrollment::getCategory, Collectors.counting()));

        countByCategory.forEach((category, count) -> {
            System.out.println(category + " : " + count);
        });

        //Sort by enrollment date
        System.out.println("\nSorted by enrollment date");
        enrollments.stream()
                .sorted(Comparator.comparing(Enrollment::getEnrollmentDate))
                .forEach(System.out::println);
    }
}
