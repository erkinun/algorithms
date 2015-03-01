package com.unlu.erkin;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ERKIN on 24/01/15.
 */
public class StackImpl<T extends Comparable> {

    List<T> list;
    T min;
    Stack<T> minStack;

    public StackImpl() {
        list = new ArrayList<T>();
        minStack = new Stack();
    }

    public void push(T value) {
        list.add(0, value);

        if (min == null) {
            min = value;
            minStack.push(min);
        }

        if (value.compareTo(min) < 0) {
            min = value;
            minStack.push(value);
        }
    }

    public T getMin() {
        return minStack.peek();
    }

    public T pop() {

        T val = list.get(0);

        if (val.equals(minStack.peek())) {
            minStack.pop();
        }

        return val;
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
