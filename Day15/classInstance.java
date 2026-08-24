import java.io.*;
import java.util.*;

class Person {
    private int age;

    public Person(int initialAge) {
        if (initialAge < 0) {
            age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        } else {
            age = initialAge;
        }
    }

    public void amIOld() {
        if (age < 13) {
            System.out.println("You are young.");
        } else if (age < 18) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are old.");
        }
    }

    public void yearPasses() {
        age++;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int age = scanner.nextInt();

            Person person = new Person(age);
            person.amIOld();

            for (int j = 0; j < 3; j++) {
                person.yearPasses();
            }

            person.amIOld();
            System.out.println();
        }

        scanner.close();
    }
}
