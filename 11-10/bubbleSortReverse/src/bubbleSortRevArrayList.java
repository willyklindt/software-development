import java.util.ArrayList;
import java.util.Iterator;

public class bubbleSortRevArrayList {

    public void sortering (ArrayList<Integer> arr)
    {

        //ArrayList<Integer> ar = new ArrayList<>();
        //int n= arr.length;
        // for(int i=0;i<n;i++)ar[i]=((int) (Math.random()*1000));
        //System.out.println(Arrays.toString(ar)); // print array
        for(int i=0;i<arr.size();i++) {
            for (int j = 0; j < arr.size()-i-1; j++) {
                if (arr.get(j) < arr.get(j+1) ){ //Vender vi < til >, så sorteres der fra storts til mindst
//swap
                    int h = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, h);
                }
            }
        }

        Iterator<Integer> iter
                = arr.iterator();

        // Displaying the values after iterating
        // through the list
        System.out.println("\nThe iterator values"
                + " of list are: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

    }



}
