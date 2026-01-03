/*Assisted Problems
Animal Hierarchy
Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses. Each subclass has a unique behavior.
Tasks:
Define a superclass Animal with attributes name and age, and a method makeSound().
Define subclasses Dog, Cat, and Bird, each with a unique implementation of makeSound().
Goal: Learn basic inheritance, method overriding, and polymorphism with simple classes. */


// Superclass
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Subclass Cat
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

// Subclass Bird
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Bird chirps");
    }
}

// Main class
public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Dog("Tommy", 3);
        Animal a2 = new Cat("Kitty", 2);
        Animal a3 = new Bird("Bell", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
