package com.unlu.erkin;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ERKIN on 24/01/15.
 */
public class StackImpl<T> {

    List<T> list;

    public StackImpl() {
        list = new ArrayList<T>();
    }

    public void push(T value) {
        list.add(0, value);
    }

    public T pop() {
        return list.get(0);
    }

    public boolean delete(T val) {
        if (list.contains(val)) {
            list.remove(val);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean insertAfter(T index, T val) {
        int idx = list.indexOf(index);

        if (idx == -1) {
            return false;
        }

        list.add(idx+1, val);

        return true;
    }
}
