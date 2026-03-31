class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

   
    void display() {
        System.out.println(name + " - " + age);
    }
}

public class PersonAttribute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Govind", 21);
		Person p2 = new Person(p1);
		p1.display();
		p2.display();
	}

}