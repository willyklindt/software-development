import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> IntList = new ArrayList<Integer>(Arrays.asList(1,2,55,42,3,69,4));
        System.out.println(findBiggestInt1(IntList));
        System.out.println(findBiggestInt2(IntList));
    }

    //Begge funktioner, altså findBiggestInt1 og 2, finder begge den største int. Men i findBiggestInt2 er der for loop inde i for loop
    // findBiggestInt2 har derfor nok en større BigO, mere krævende

    public static Integer findBiggestInt1(ArrayList<Integer> list){ //Denne har lineær time
        Integer biggest = null;

        for (int i = 0; i < list.size(); i++){
            if (biggest == null || biggest < list.get(i)){
                biggest = list.get(i);
            }
        }

        return biggest;
    }
    public static Integer findBiggestInt2(ArrayList<Integer> list){ //Denne har en quadradic time.
        boolean biggere = false;
        for (int i = 0; i < list.size(); i++){
            biggere = false;
            for (int j = 0; j<list.size(); j++) {
                if (list.get(i) < list.get(j))
                    biggere = true;
            }
                if (biggere == false){
                    return list.get(i);
                }
            }
         return null;
    }

}
