public class XCalculator {
    
    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        numbers.multiplier();
    }
}

class Numbers {
    int firstDigit;
    int secondDigit;
    int maxValue;

Numbers(){
    this.firstDigit = 1;
    this.secondDigit = 16;
    this.maxValue = 9;
}

public void multiplier(){
    for (int firstDigit = 1; firstDigit < maxValue; firstDigit++) {
        System.out.println(firstDigit + " X " + firstDigit * secondDigit);
        }
    }
}

