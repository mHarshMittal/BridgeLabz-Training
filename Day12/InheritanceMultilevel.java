class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Mammal extends Animal {

    void walk() {
        System.out.println("Mammal is walking");
    }
}

class Dog extends Mammal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

class Puppy extends Dog {

    void play() {
        System.out.println("Puppy is playing");
    }
}

public class Main {

    public static void main(String[] args) {

        Puppy p = new Puppy();

        p.eat();
        p.walk();
        p.bark();
        p.play();
    }
}