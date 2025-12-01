import java.util.*;  

class Animal {
    String name;
    int age;

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog says: Woof Woof!");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat says: Meow Meow!");
    }
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("Bird says: Tweet Tweet!");
    }
}

public class import java.util.*;  // Import statement

class Animal {
    String name;
    int age;

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog says: Woof Woof!");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat says: Meow Meow!");
    }
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("Bird says: Tweet Tweet!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog d = new Dog();
        Cat c = new Cat();
        Bird b = new Bird();

        d.makeSound();
        c.makeSound();
        b.makeSound();

        sc.close();
    }
}
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog d = new Dog();
        Cat c = new Cat();
        Bird b = new Bird();

        d.makeSound();
        c.makeSound();
        b.makeSound();

        sc.close();
    }
}
