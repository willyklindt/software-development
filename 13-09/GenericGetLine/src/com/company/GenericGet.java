package com.company;
import java.util.ArrayList;

public class GenericGet <T> {
    public GenericGet(){};

    public T getItem(ArrayList<T> list, Integer index){
        if (index >=0 && index < list.size())
            return list.get(index);
        return null;
    }
}
