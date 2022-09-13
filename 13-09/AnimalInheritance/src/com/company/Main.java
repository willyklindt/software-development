package com.company;

public class Main {

    public static void main(String[] args) {
	Animal a1, a2,a3;
    // a1 = new Animal();
    a2 = new Dog();
    a3 = new Puppy();

//   a1.sound();
    a2.sound();
    a3.sound();

    }
}

abstract class Animal{ // en abstract class kan ikke lave objecter.
    abstract void sound(); //Her er metoden sound abstract. Den kan altså ikke kaldes direkte i Animal, men kun gennem klasser der arver fra denne
}

class Dog extends Animal{ //Extends betyder at klassen arver fra anden klasse, Dog arver fra Animal
    @Override
    void sound(){ //arver fra klassen Animal, altså metoden sound() fra Animal
        System.out.println("arf arf woof");
    }
}

class Puppy extends Dog{
    @Override
    void sound() {
        System.out.println("woof woof");
    }
}