package com.unlu.erkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ERKIN on 01/03/15.
 */
public class SetOfStacks<T> {

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
    }

    private int index = 0;
    private int threshold;
    private List<Stack<T>> stackList = new ArrayList<>();

    public SetOfStacks(int threshold) {
        stackList.add(new Stack<T>());
        this.threshold = threshold;
    }

    public void push(T val) {
        Stack<T> cur = stackList.get(index);

        if (cur.size() >= threshold) {
            //create a new stack
            stackList.add(new Stack<T>());
            index++;
        }

        stackList.get(index).add(val);
    }

    public T pop() {
        T val = stackList.get(index).pop();

        if (stackList.get(index).size() == 0) {
            stackList.remove(index);
            index--;
        }

        return val;
    }
}
