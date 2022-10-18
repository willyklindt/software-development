package Bubblesort;

import java.util.ArrayList;

public class BubbleArrayList {
    public void listSort(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    // swap
                    int h = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, h);
                }
            }
        }
        System.out.println(array); // print array
        }
    }

