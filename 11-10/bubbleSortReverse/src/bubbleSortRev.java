import java.util.Arrays;

public class bubbleSortRev {

    public void sortering (int[] arr)
    {

        int[] ar=arr;
        //int n= arr.length;
       // for(int i=0;i<n;i++)ar[i]=((int) (Math.random()*1000));
        //System.out.println(Arrays.toString(ar)); // print array
        for(int i=0;i<ar.length;i++) {
            for (int j = 0; j < ar.length-i-1; j++) {
                if (ar[j] < ar[j+1]) { //Vender vi < til >, så sorteres der fra storts til mindst
//swap
                    int h = ar[j];
                    ar[j] = ar[j+1];
                    ar[j + 1] = h;
                }
            }
        }
        System.out.println(Arrays.toString(ar)); // print array
    }
}
