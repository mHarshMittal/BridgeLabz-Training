import java.util.*;

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Student {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = sc.nextInt();

        Person p = new Person();

        p.setName(name);
        p.setAge(age);

        System.out.println(p.getName());
        System.out.println(p.getAge());

        sc.close();
    }
}