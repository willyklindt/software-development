public class Animalinheritance {

    public static void main(String[] args) {
<<<<<<< HEAD
<<<<<<< HEAD
        Animal a1, a2, a3, a4;
=======
        Animal a1, a2, a3, a4, a5;
>>>>>>> parent of 8df7f6f (Der er nu en dog a6)
=======
        Animal a1, a2, a3, a4, a5, a6;
>>>>>>> parent of bb38638 (Sletter hunde)
        a1 = new Animal();
        a2 = new Dog();
        a3 = new Doggy();
        a4 = new Doggy();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        a5 = new Doggy();
>>>>>>> parent of 8df7f6f (Der er nu en dog a6)
=======
        a5 = new Doggy();
        a6 = new Doggy();
>>>>>>> parent of bb38638 (Sletter hunde)

        a1.sound();
        a2.sound();
        a3.sound();
        a4.sound();
<<<<<<< HEAD

=======
        a5.sound();
>>>>>>> parent of bb38638 (Sletter hunde)
    }
}

class Animal {
    void sound() {
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
        System.out.println("woof woof woof");
    }
}
