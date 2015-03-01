package com.unlu.erkin;

import java.util.Stack;

/**
 * Created by ERKIN on 01/03/15.
 */
public class MyQueue<T> {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        System.out.println(myQueue.remove());

        myQueue.add(5);

        System.out.println(myQueue.remove());
    }

    private Stack<T> first;

    public MyQueue() {
        first = new Stack<>();
    }

    public void add(T val) {
        first.add(val);
    }

    public T remove() {

        Stack<T> temp = new Stack<>();
        while (!first.isEmpty()) {
            temp.push(first.pop());
        }

        //now we get the first item in the queue
        T head = temp.pop();

        while (!temp.isEmpty()) {
            first.push(temp.pop());
        }

        return head;
    }

}
