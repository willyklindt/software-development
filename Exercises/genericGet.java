package Exercises;
import java.util.ArrayList;
import java.util.Arrays;

public class genericGet <T> {

public static void main(String[] args) {
    genericGet myFind = new genericGet<>();
    ArrayList<String> myStringList = new ArrayList<>(Arrays.asList("We", "love", "chips"));
    System.out.println(myFind.getItem(myStringList, 0));
}


   public genericGet(){}; 

   public T getItem (ArrayList<T> list, Integer index) {
        if (index >= 0 && index < list.size()){
            return list.get(index);
        }
    return null;

   }
   
}
