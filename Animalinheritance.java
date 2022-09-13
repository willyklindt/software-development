public class Animalinheritance {
    
    public static void main(String[] args) {
        Animal a1, a2, a3;
        a1 = new Animal();
        a2 = new Dog();
        a3 = new Doggy();

        a1.sound();
        a2.sound();
        a3.sound();
    }
}

 class Animal {
    void sound(){
        System.out.println("Some sound");
    }
}


class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("arf arf");
    }
}

class Doggy extends Dog {
    @Override
    void sound() {
        System.out.println("woof woof");
    }
}

