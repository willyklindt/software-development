import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> myStringList = CreateInitArrayListString();
        Iterator<String> itrStringList = myStringList.iterator(); //Iterator som bruges til at løbe igennem ArrayListen

        while(itrStringList.hasNext()){ //hasNext Returns true if the iteration has more elements.
            System.out.println(itrStringList.next()); //Returns the next element in the iteration.
        }
        //Maps
        TreeMap<Integer, String> MyIntegerStringTreeMap = CreateIntegerStringTreeMap();
        Iterator<Map.Entry<Integer,String>> itrIntegerStringTreeMap = MyIntegerStringTreeMap.entrySet().iterator();
        while (itrIntegerStringTreeMap.hasNext()) {

            Map.Entry entry = itrIntegerStringTreeMap.next();
            System.out.println("Age: " + entry.getKey() + " Name: " + entry.getValue());
        }

        //LinkedList
        LinkedList<String>  MyStringLinkedList = CreateInitLinkedList();
        Iterator<String> itrStringLinkedList = MyStringLinkedList.iterator();
        while (itrStringLinkedList.hasNext()){
            System.out.println(itrStringLinkedList.next());
        }

        //Stack
        Stack<String> MyStringStack = CreateInitStackString();
        Iterator<String> itrStringStack = MyStringStack.iterator();
        while (itrStringStack.hasNext()){
            System.out.println(itrStringStack.next());
        }

        //PriorityQue
        PriorityQueue<String> MyStringPriorityQueue = CreateInitPriorityQueString();
        Iterator<String> itrStringPriorityQueue = MyStringPriorityQueue.iterator();
        while (itrStringPriorityQueue.hasNext()){
            System.out.println(itrStringPriorityQueue.next());
        }
        }



    public static ArrayList<String> CreateInitArrayListString(){
        ArrayList<String> ArrayListofString = new ArrayList<String>();
        ArrayListofString.add("Bob");
        ArrayListofString.add("Albert");
        ArrayListofString.add("Lucy");
        ArrayListofString.add("Berta");
        ArrayListofString.add("Aisha");
        return ArrayListofString;
    }

    public static TreeMap<Integer, String> CreateIntegerStringTreeMap(){ // Når TreeMap printes, så sorteres den ift. key. I dette tilfælde alder
        TreeMap<Integer, String> TreeMapIntegerString = new TreeMap<Integer, String>();
        TreeMapIntegerString.put(30, "Bob");
        TreeMapIntegerString.put(23, "Albert");
        TreeMapIntegerString.put(22, "Lucy");
        TreeMapIntegerString.put(15, "Aisha");
        TreeMapIntegerString.put(29, "Berta");
        return TreeMapIntegerString;
    }

    public static LinkedList<String> CreateInitLinkedList(){
        LinkedList<String> newLinkedListofString = new LinkedList<String>();
        newLinkedListofString.add("Hans");
        newLinkedListofString.add("Morten");
        newLinkedListofString.add("Nice");
        newLinkedListofString.add("Martin");

        //Insert elements
        return newLinkedListofString;
    }
    public static Stack<String> CreateInitStackString(){
        Stack<String> newStackofString = new Stack<String>();
        newStackofString.push("Wassup");
        newStackofString.push("This works");
        newStackofString.push("StacksAreFun");
        return newStackofString;
    }

    public static PriorityQueue<String> CreateInitPriorityQueString(){
        PriorityQueue<String> newPriorityQueString = new PriorityQueue<String>();
        newPriorityQueString.add("QueString");
        newPriorityQueString.add("Is");
        newPriorityQueString.add("A");
        newPriorityQueString.add("Hard");
        newPriorityQueString.add("Concept");
        return newPriorityQueString;
    }
}
