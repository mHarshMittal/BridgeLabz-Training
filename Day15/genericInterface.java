import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return this.score - other.score;
    }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}

public class Solution {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Aman", 85));
        studentList.add(new Student("Rahul", 70));
        studentList.add(new Student("Priya", 95));
        studentList.add(new Student("Neha", 80));

        Collections.sort(studentList);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}