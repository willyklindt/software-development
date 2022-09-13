package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	GenericGet myFind = new GenericGet();
    ArrayList<String> myStringList = new ArrayList<>(Arrays.asList("We", "Love", "Algorithms", "And", "DataStructures"));

        System.out.println(myFind.getItem(myStringList, 1));
    }
}
