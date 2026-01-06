import java.util.ArrayList;
import java.util.List;

//exception
class InvalidMarkException extends Exception {
    InvalidMarkException(String m) {
        super(m);
    }
}

// student class
class Student {
    String name;
    String[] sub;
    int[] marks;

    Student(String name, String[] sub, int[] marks) {
        this.name = name;
        this.sub = sub;
        this.marks = marks;
    }
}

public class StudentReport {

    static List<Student> list = new ArrayList<>();

    static int avg(int[] m) {
        int t = 0;
        for (int x : m) {
            t += x;
        }
        return t / m.length;
    }

    static String grade(int a) {
        if (a >= 75) return "A";
        if (a >= 50) return "B";
        return "Fail";
    }

    static void addStudent(String name, String[] sub, int[] m)
            throws InvalidMarkException {

        for (int x : m) {
            if (x < 0 || x > 100) {
                throw new InvalidMarkException("Marks must be 0 to 100");
            }
        }
        list.add(new Student(name, sub, m));
    }

    static void showReport() {
        for (Student s : list) {
            System.out.println("Name: " + s.name);
            for (int i = 0; i < s.sub.length; i++) {
                System.out.println(s.sub[i] + ": " + s.marks[i]);
            }
            int a = avg(s.marks);
            System.out.println("Average: " + a);
            System.out.println("Grade: " + grade(a));
            System.out.println("----------------");
        }
    }

    public static void main(String[] args) {
        try {
            String[] sub = {"Math", "Science", "English"};
            int[] m = {70, 80, 60};

            addStudent("Ravi", sub, m);
            showReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
