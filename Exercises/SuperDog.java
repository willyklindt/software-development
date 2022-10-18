package Exercises;
public class SuperDog {

    public static void main(String[] args) {
        Animal myAnimal = new Animal("Thomas");
        Doggy myDoggy = new Doggy("Lars");
        Pupper myPupper = new Pupper("Johan");

        myAnimal.sound();
        myDoggy.sound();
        myPupper.sound();
    }
}

class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Some sound");

    }
}

class Doggy extends Animal {
    public Doggy(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Barki Bark");
    }
}

class Pupper extends Doggy {
    public Pupper(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Wuffi");
    }
}
