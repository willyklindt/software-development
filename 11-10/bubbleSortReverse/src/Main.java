import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    //Exercise from lecture, 11-10
    public static void main(String[] args) {
	int[]list = {6,7,5,3,9,2,34}; //bruger ikke denne
    var bubbleRev = new bubbleSortRev();
    bubbleRev.sortering(list);

        ArrayList<Integer> listWithArrayList = new ArrayList<Integer>();
        listWithArrayList.add(3);
        listWithArrayList.add(56);
        listWithArrayList.add(1);
        listWithArrayList.add(78);
        listWithArrayList.add(34);
        listWithArrayList.add(7);
        var bubbleRevArrayList = new bubbleSortRevArrayList();
        bubbleRevArrayList.sortering(listWithArrayList);



    }
}
