import java.util.ArrayList;
import java.util.Arrays;

public class BiggestNumber {

    public static void main(String[] args) {
        ArrayList<Integer> IntList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 55, 66, 77, 1, 2, 95, 6));
        System.out.println(findBInteger1(IntList));
        System.out.println(findBInteger2(IntList));
    }

    public static Integer findBInteger1(ArrayList<Integer> list) { // refer to it as list // ligesom der kan stå int
                                                                   // kroner som en variable.
        Integer biggest = null;
        for (int i = 0; i < list.size(); i++) {
            if (biggest == null || biggest < list.get(i)) {
                biggest = list.get(i);
            }
        }
        return biggest;
    }

    public static Integer findBInteger2(ArrayList<Integer> list) {
        boolean bigger = false;
        for (int i = 0; i < list.size(); i++) {
            bigger = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    bigger = true;
                }
                if (bigger == false) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}