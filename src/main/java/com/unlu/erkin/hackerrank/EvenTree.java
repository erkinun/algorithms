package com.unlu.erkin.hackerrank;

import java.io.*;
import java.util.*;

public class EvenTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        Graph g = new Graph(vertexCount);

        for (int i = 0; i < edgeCount; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            g.addEdge(from, to);
        }

        System.out.println(g.neededCutsForForest());
    }

    public static class Graph {
        private ArrayList<ArrayList<Integer>> adjs; //maybe use a set here
        private int vertexCount;

        public Graph(int vertCount) {
            vertexCount = vertCount;
            adjs = new ArrayList<ArrayList<Integer>>(vertCount+1); //0 is not used
        }

        public void addEdge(int from, int to) {
            adjs.get(from).add(to);
            adjs.get(to).add(from);
        }

        public void removeEdge(int from, int to) {
            adjs.get(from).remove(to);
            adjs.get(to).remove(from);
        }

        public int neededCutsForForest() {

            int needed = 0;

            for (int i = 1; i <= vertexCount; i++) {
                //see if there is a even numbered sub tree
                for (Integer adj : adjs.get(i)) {
                    if (findSubtreeCount(adj, i) % 2 == 0) {
                        needed++;
                        removeEdge(i, adj);
                    }
                }
            }

            return needed;
        }

        private int findSubtreeCount(int adj, int from) {
            Stack<Integer> elems = new Stack<>();
            elems.add(adj);

            int count = 0;

            while (!elems.isEmpty()) {
                count++;
                Integer elem = elems.pop();
                for (Integer other : adjs.get(elem)) {
                    if (other != from) {
                        elems.push(other);
                    }
                }
            }

            return count;
        }
    }
}