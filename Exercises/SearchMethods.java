package Exercises;
import java.util.ArrayList;
import java.util.List;

public class SearchMethods {

public static void main(String[] args) {
    Integer intarray[] = {10, 7, 4, 2, 9, 8, 11, 18};
    List <String> Names = new ArrayList<String>();
    Names.add("Albert");
    Names.add("Robert");
    Names.add("Ulla");
    Names.add("Aske");
    Names.add("Berta");

}
   /*  if(indexofElement != null)
    Integer indexofElement;
    indexofElement = SearchMethods.SequentialSearch(intarray, 11);
        System.out.println("in intarray 11 at index " + indexofElement + "and we retrieved" + intarray[indexofElement]);

    indexofElement = SearchMethods.SequentialSearch(Names, "Ulla");
    if(indexofElement != null)
        System.out.println("in Names Ulla is at index " + indexofElement + "and we retrieved" + Names.get(indexofElement));
}*/

private static <T extends Comparable<T>> Integer SequentialSearch(T[] list, T object) {
    return null;
}

public static <T extends Comparable <T>> Integer SequentialSearch(List <T> list, T object){
    return null;
}

public static <T extends Comparable <T>> Integer JumpSearch(T[] list, T object){
    return null;
}

public static <T extends Comparable <T>> Integer JumpSearch(List <T> list, T object){
    return null;
}

public static <T extends Comparable <T>> Integer BinarySearch(T[] list, T object){
    return null;
}

public static <T extends Comparable <T>> Integer BinarySearch(List <T> list, T object){
    return null;
}

}