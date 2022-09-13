package com.company;

public class Main {

    public static void main(String[] args) {
	//Animal myAnimal = new Animal("Dave");
    Dog myDog = new Dog("Max");
    Puppy myPuppy = new Puppy("Fifi");
  //  myAnimal.sound();
    myDog.sound();
    myPuppy.sound();
    }
}

abstract class Animal {
    String name;
    public Animal(String name){
    this.name = name;
    }

    abstract public void sound ();
    //{
      //  System.out.println(" Some sound");
    //}
}

class Dog extends Animal{
    public Dog (String name){
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(" Woof Woof");
    }
}

class Puppy extends Dog {
    public Puppy (String name){
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(" arf arf arf");
    }
}