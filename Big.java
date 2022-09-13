import java.math.BigInteger;

public class Big {
    
    static BigInteger factorial (int N) {
        BigInteger factorialBigInteger = new BigInteger("1");
        for (int i = 1; i < N; i++) 
            factorialBigInteger = factorialBigInteger.multiply(BigInteger.valueOf(i));
        
        return factorialBigInteger;
    }

public static void main(String[] args) {
    System.out.println("Factorial table!");
    int N = 30;
    for (int i = 1; i < N; i++) {
        System.out.println("Integer: " + i + " Factorial :" + factorial(i));
    }
}
}
