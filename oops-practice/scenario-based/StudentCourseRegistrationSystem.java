import java.util.*;

// Student registration and course enrollment demo.
public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        RegistrationService service = new InMemoryRegistrationService(3);
        Student s1 = new Student("S1", "Riya");

        service.registerStudent(s1);
        service.enroll(s1.getId(), new Course("C1", "DSA"));
        service.enroll(s1.getId(), new Course("C2", "DBMS"));
        System.out.println("Courses for Riya: " + service.viewEnrollments(s1.getId()));
    }
}

abstract class BasePerson {
    private final String id;
    private final String name;

    protected BasePerson(String id, String name) {
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

class Student extends BasePerson {
    private final Map<String, String> grades = new HashMap<>();

    Student(String id, String name) {
        super(id, name);
    }

    public void addGrade(String courseId, String grade) {
        grades.put(courseId, grade);
    }

    public Map<String, String> getGrades() {
        return Collections.unmodifiableMap(grades);
    }
}

class Course {
    private final String id;
    private final String title;

    Course(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return title;
    }
}

interface RegistrationService {
    void registerStudent(Student student);
    void enroll(String studentId, Course course);
    void drop(String studentId, String courseId);
    List<String> viewEnrollments(String studentId);
}

class CourseLimitExceededException extends RuntimeException {
    CourseLimitExceededException(String msg) {
        super(msg);
    }
}

class InMemoryRegistrationService implements RegistrationService {
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, List<Course>> enrollments = new HashMap<>();
    private final int maxCourses;

    InMemoryRegistrationService(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    @Override
    public void registerStudent(Student student) {
        students.put(student.getId(), student);
        enrollments.put(student.getId(), new ArrayList<>());
    }

    @Override
    public void enroll(String studentId, Course course) {
        List<Course> list = getEnrollments(studentId);
        if (list.size() >= maxCourses) {
            throw new CourseLimitExceededException("Course limit reached");
        }
        list.add(course);
    }

    @Override
    public void drop(String studentId, String courseId) {
        List<Course> list = getEnrollments(studentId);
        list.removeIf(c -> c.getId().equals(courseId));
    }

    @Override
    public List<String> viewEnrollments(String studentId) {
        List<Course> list = getEnrollments(studentId);
        List<String> titles = new ArrayList<>();
        for (Course c : list) {
            titles.add(c.toString());
        }
        return titles;
    }

    private List<Course> getEnrollments(String studentId) {
        List<Course> list = enrollments.get(studentId);
        if (list == null) {
            throw new IllegalArgumentException("Student not found " + studentId);
        }
        return list;
    }
}

