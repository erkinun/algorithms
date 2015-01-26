package com.unlu.erkin;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by ERKIN on 11/01/15.
 */
public class PizzaServer {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //read customers
        Scanner scanner = new Scanner(System.in);
        int numCustomers = scanner.nextInt();

        scanner.nextLine();
        Customer first = new Customer(scanner.nextInt(), scanner.nextInt());

        //put them in a sorted data str for cooking time
        TreeSet waitingList = new TreeSet(new CustomerComp());
        for (int i = 1; i < numCustomers; i++) {
            waitingList.add(new Customer(scanner.nextInt(), scanner.nextInt()));
        }

        //start the timer
        int timer = 0;
        int totalWaitedTime = 0;
        //first customer
        timer += first.getArr() + first.getCook();
        //get a customer somehow
        //cook pizza
        //calculate the waiting time for current customer
        //sum it up when finished

        //return the avg waiting time
    }

    private static class Customer {
        private int arrTime;
        private int cookTime;

        Customer(int arrTime, int cookTime) {
            this.arrTime = arrTime;
            this.cookTime = cookTime;
        }

        public int getArr() {
            return arrTime;
        }

        public int getCook() {
            return cookTime;
        }
    }

    private static class CustomerComp implements Comparator<Customer> {
        public int compare(Customer c1, Customer c2) {
            if (c1.getCook() < c2.getCook()) {
                return -1;
            }
            else if (c1.getCook() == c2.getCook()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
