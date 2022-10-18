package Exercises;
import java.math.BigInteger;

//Håber det virker
public class Big {
    public static void main(String[] args){
        System.out.println( "Factorial results");
        for (int i = 0; i <= 30; i++) {
            
            System.out.println(i+"!="+factorial(i));

            
        }
    }
    public static BigInteger factorial(int n){
        BigInteger big = BigInteger.valueOf(n);
        for (int i = (n - 1); i > 1; i--) {
            big = big.multiply(BigInteger.valueOf(i));
           }
        return big;
    }
}
