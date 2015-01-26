package com.unlu.erkin;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ERKIN on 25/01/15.
 */
public class CyclicListFinder {

    public boolean isAcyclic(Node first) {

        Node current = first;
        Set<Node> visited = new TreeSet<Node>();
        visited.add(current);
        while (current.next != null) {
            if (!visited.add(current.next)) {
                return false;
            }

            current = current.next;
        }

        return true;
    }

    public static class Node implements Comparable {
        Node next;
        int val;

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;

            if (node == this) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
