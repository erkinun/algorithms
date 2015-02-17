package com.unlu.erkin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ERKIN on 15/02/15.
 */
public class PowerSet {

    public static void main(String[] args) {

        Set<Integer> org = new HashSet<>();
        org.add(1);
        org.add(2);
        org.add(3);
        Set<Set<Integer>> power = findPowerSet(org);

        for (Set<Integer> subSet : power) {
            System.out.print("set: ");
            for (Integer i : subSet) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    public static Set<Set<Integer>> findPowerSet(Set<Integer> orgs) {
        Set<Set<Integer>> power = new HashSet<>();
        power.add(new HashSet<>()); //empty?


        for (Integer i : orgs) {
            Set<Set<Integer>> temp = new HashSet<>();
            for (Set<Integer> subSets : power) {
                Set<Integer> cur = new HashSet<Integer>(subSets);
                cur.add(i);
                temp.add(cur);
            }
            power.addAll(temp);
        }

        return power;
    }
}
