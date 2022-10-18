import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Integer intarr[] = {10, 7, 8, 9, 5, 4, 3, 11, 2, 1, 6};
        Arrays.sort(intarr);

        List<String> Names = new ArrayList<String>();
        Names.add("Albert");
        Names.add("Robert");
        Names.add("Ulla");
        Names.add("Aske");
        Names.add("Berta");
        Integer indexofElement;
        indexofElement = SearchMethod.SequentialSearch(intarr, 11);
        if (indexofElement != null)
        System.out.println("in intarr 11 is at index :" + indexofElement +  "and we retrieved: " + intarr[indexofElement]);
        indexofElement = SearchMethod.SequentialSearch(Names, "Berta");
        if (indexofElement != null)
        System.out.println("in Names Ulla is at index :" + indexofElement +  "and we retrieved: " + Names.get(indexofElement));


        indexofElement = SearchMethod.JumpSearch(intarr, 9);
        if (indexofElement != null)

        System.out.println("jumpsearch index: "+ indexofElement +" of: "+ intarr[indexofElement]);

        indexofElement = SearchMethod.BinarySearch(Names, "Aske", 0, 4 );
        if (indexofElement != null)
        System.out.println("in Names Aske is at index :" + indexofElement +  "and we retrieved: " + Names.get(indexofElement));

        indexofElement = SearchMethod.BinarySearch(intarr, 4, 0, 5 );
        if (indexofElement != null)
        System.out.println("in intarr 4 is at index :" + indexofElement +  "and we retrieved: " + intarr[indexofElement]);

        Integer sortedintarr[] = {1,2,3,4,5,6,7,8,9,10,11,42};
        List<String> SortedNames = new ArrayList<String>();
        SortedNames.add("Albert");
        SortedNames.add("Aske");
        SortedNames.add("Berta");
        SortedNames.add("Robert");
        SortedNames.add("Ulla");
        indexofElement = SearchMethod.BinarySearch(SortedNames, "Berta", 0, SortedNames.size()-1);
        if (indexofElement != null)
            System.out.println("in SortedNames Berta is at index :" + indexofElement +  "and we retrieved: " + SortedNames.get(indexofElement));
            else
            System.out.println("Name not found");


    }
}
