package com.company;

public class Main {

    public static void main(String[] args) {
	Rational rational = new Rational(); // laver object
        System.out.println(rational);
    Rational rational2 = new Rational(7,22); //laver object med parametre
    rational.numerator = 32;
    rational.denominator = 2;

    rational.printRational(); //kalder metoden printRational

        rational2.printRational();
        System.out.println(rational);
       rational2.invert();
        System.out.println(rational2);

        System.out.println(rational2.toDouble());



        Rational rational3 = new Rational(7, -3);
        System.out.println(rational + "Denne bliver nu negated");
        rational3.negate();
        rational3.printRational();

        Rational rationalAddedTogether;
        Rational rationalAdd1 = new Rational(7,56);
        Rational rationalAdd2 = new Rational(2,56);
        rationalAddedTogether = rationalAdd1.add(rationalAdd2);
        System.out.println(rationalAddedTogether);

        System.out.println(rational2.reduce(32 , 4));
        System.out.println(rational2);
    }
}

class Rational {
     int numerator; //klassevariabler
     int denominator;

    Rational(){ //contructor
        this.numerator = 0;
        this.denominator = 1;
    }

    Rational (int numerator, int denominator){ //Contructor med parametre
        this.numerator = numerator;
        this.denominator = denominator;
    }

void invert(){ //Bytter om på værdierne
        int swapNumerator = this.denominator;
        int swapDenominator = this.numerator;
        this.numerator = swapNumerator;
        this.denominator = swapDenominator;
}

double toDouble(){ //Konverterer fra int til double
double numerator = this.numerator;
double denominator = this.denominator;
double sum = numerator/denominator;
return sum;

    }

double reduce(double n1, double n2){ //Bruger modulus, til at finde laveste tal de to tal går op i
        if (n2== 0){
            return n1;
        }
        return reduce(n2, n1 % n2);

}




    void printRational(){ //printer værdier i object
        System.out.println(this.numerator + "/" + this.denominator);
    }

   public String toString(){//printer hele objectet via toString metoden. Virker uden du kalder på den
       return numerator+" / "+denominator;
    }

    void negate (){ // reverser the sign of a rational number
        this.numerator = this.numerator*-1;
        this.denominator = this.denominator*-1;

    }

    public Rational add(Rational a)
    {
        Rational result;
        result = new Rational(0,0);
        result.numerator = numerator * a.denominator + a.numerator * denominator;
        result.denominator = denominator * a.denominator;
        return result;
    }


}
