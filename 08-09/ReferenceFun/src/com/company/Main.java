package com.company;

public class Main {

    public static void main(String[] args) {
	Dog aDog=new Dog("Max");
    Dog oldDog= aDog;
// pass aDog to foo1
    foo1(aDog);
    System.out.println(" The dog aDog after foo1 is: "+ aDog.getName());
    foo2(aDog);
    System.out.println(" The dog aDog after foo2 is: "+ aDog.getName());
    }

    public static void foo1(Dog d){ //Eksempel på at instansen af objektet dog, ikke ændrer navn (Der bliver nemlig i denne metode, lavet ny instance)
        d = new Dog("Fifi");
        System.out.println(" The dog d in foo is:"+ d.getName());
    }
    public static void foo2(Dog d){
        d.setName("Fifi");
        System.out.println(" The dog d in foo2 is: "+ d.getName());
    }
}

class Dog{
    String name;
    public Dog(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { //void betyder, at metode ikke returnerer noget
        this.name = name;
    }
}
