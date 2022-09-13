package com.company;
import java.math.BigInteger;

public class Big {

    public static void main(String[] args) {
        System.out.println( "Factorial results");
        for (int i=0; i<=30;i++){
            System.out.println(i+"!="+factorial(i));
        }
        System.out.println(pow(32,3)); // Kalder metoden pow, i dette eksempel regnes der 32^3 ud.
    }
    public static BigInteger factorial(int n){
       //factorial(7) is the same as 7! = 7*6*5*4*3*2*1
        BigInteger factorial = BigInteger.ONE;
       for (int i = n; i> 0; i--){
           factorial = factorial.multiply(BigInteger.valueOf(i));

       }
       return factorial; //BigInteger er ikke mutable, dvs. man kan ikke ændre objektet kun lave nye.
    }


public static BigInteger pow(int x, int n) { //x = tal, n = hvilket tal der skal opløftes til
    if (n == 0) return BigInteger.valueOf(1); //Hvis der opløftes med tallet 0, retur n = 1

    // find x to the n/2 recursively
    BigInteger t = pow(x, n / 2);

    // if n is even, the result is t squared
    // if n is odd, the result is t squared times x
    if (n % 2 == 0) { //Hvis tallet der opløftes med % 2 = 0, så returner t1 gange t2
        return t.multiply(t);
    } else {
        t.multiply(t); // ellers t*t*x, og returner dette.
        return t.multiply(t).multiply(BigInteger.valueOf(x));
    }
}
}
