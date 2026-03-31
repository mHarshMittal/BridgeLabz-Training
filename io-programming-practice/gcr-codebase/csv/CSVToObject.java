import java.io.*;
import java.util.*;

public class CSVToObject {

    static class Student {
        int id, age, marks;
        String name;

        Student(int id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Student(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Integer.parseInt(d[3])
                ));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Student s : list) {
            System.out.println(s.id + " " + s.name + " " + s.age + " " + s.marks);
        }
    }
}

