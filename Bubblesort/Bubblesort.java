package Bubblesort;
import java.util.Arrays;

    public class Bubblesort{
    
        public void sortering(int[] array){
        
        int [] ar = array;
        int n = array.length;

        System.out.println(Arrays.toString(ar)); // print array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    // swap
                    int h = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = h;
                }
            }
        }
        System.out.println(Arrays.toString(ar)); // print array
        }
    }
