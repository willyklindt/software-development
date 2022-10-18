package Exercises;
public class RationalNumber {
    
    public static void main(String[] args) {
        Rational rational = new Rational();
        Rational rational2 = new Rational(12, 18);
        
        rational.printRational();
        rational2.printRational();
    }
}

class Rational { //Class
    int numerator;
    int denominator;

    Rational(){ // Constructor
        this.numerator = 0;
        this.denominator = 1;
    }

    Rational(int numerator, int denominator){ // Constructor med parametre
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString(){ // Overflædig hvis man benytter sig af printRational
        return numerator + " " + denominator;
    }

    public void printRational(){ // Metode der printer tallene

        System.out.println(this.numerator + " + " + this.denominator);
        System.out.println();
    }

}

