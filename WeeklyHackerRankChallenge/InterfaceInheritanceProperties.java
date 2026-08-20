interface Animal {
    int MAX_AGE = 20;

    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {

    public void eat() {
        System.out.println("Eating");
    }

    public void play() {
        System.out.println("Playing, max age is " + MAX_AGE);
    }
}

public class InterfaceInheritanceProperties {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
        dog.play();

        System.out.println("Max age using Animal: " + Animal.MAX_AGE);
    }
}