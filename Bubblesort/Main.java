package Bubblesort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] liste = { 8, 23, 92, 1, 5, 77, 99 };
        ArrayList <Integer> bubbely = new ArrayList<Integer>();

        bubbely.add(2);
        bubbely.add(4);
        bubbely.add(87);
        bubbely.add(34);
        bubbely.add(90943);
        bubbely.add(237);
        bubbely.add(1);
        
        var bubblesorty = new Bubblesort();
        bubblesorty.sortering(liste);
        
        var bubbelyArraySorting = new BubbleArrayList();
        bubbelyArraySorting.listSort(bubbely);
        
        
    }
}
