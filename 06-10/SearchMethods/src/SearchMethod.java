import java.util.List;

class SearchMethod {

    //SequentialSearch kan tage i mod typen T (generic), men den skal være kompatibel med typen. Den returnerer en Integer
    public static <T extends Comparable<T>> Integer SequentialSearch(T[] list, T object) {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i].compareTo(object) == 0){
                return i;
            }
        }
            return null;
    }

    public static <T extends Comparable<T>> Integer SequentialSearch(List<T> list, T object) {

        for (int i = 0; i < list.size(); i++ )
        {
            if (list.indexOf(object) != -1 )
            {
                return list.indexOf(object);
            }
        }

        return null;
    }

    public static <T extends Comparable<T>> Integer JumpSearch(T[] list, T object) {
        int j = (int) Math.sqrt(list.length); //squarerootlist sker der typecasting på, så det bliver en int
        int prev=0;


        while (list[Math.min(j-1, list.length-1)].compareTo(object) < 0) //Kører så længe længden af list er mindre end object, altså så man ikke søger længere end hvad listens længde er
        {
            prev = j;
            //System.out.println(prev);
            j += j;

            if (prev >= list.length){
                System.out.println("Den allerførste kaldes");
                return null;

            }

        }
        while (list[prev].compareTo(object) < 0)
        {
            prev++;
            if (prev == j || prev == list.length) {
                System.out.println("Den første kaldes");
                return null;
            }

        }
        if (list[prev] == object){
            System.out.println(prev);
            return prev;
        }
        System.out.println("Den anden kaldes");
        return null;
    }

    public static <T extends Comparable<T>> Integer JumpSearch(List<T> list, T object) {


        return null;
    }

    public static <T extends Comparable<T>> Integer BinarySearch(T[] list, T object, int low, int high) { // int og og high, er start og slut på array
        if (low > high)
            return null;
        int mid = (low + high) / 2;
        if (list[mid].compareTo(object) == 0) {
            return mid;
        }
        if (list[mid].compareTo(object) < 0) {
            return BinarySearch(list, object, low, mid - 1);
        }
        if (list[mid].compareTo(object) > 0) {
            return BinarySearch(list, object, mid + 1, high);
        }
        return null;
    }

    public static <T extends Comparable<T>> Integer BinarySearch(List<T> list, T object, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high) / 2;
        if (list.get(mid).compareTo(object) == 0) {
            return mid;
        }
        if (list.get(mid).compareTo(object) < 0) {
            return BinarySearch(list, object, low, mid - 1);
        }
        if (list.get(mid).compareTo(object) > 0) {
            return BinarySearch(list, object, mid + 1, high);
        }
        return null;

    }
}
