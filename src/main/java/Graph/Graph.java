package Graph;

import java.util.*;

public class Graph {
    static void add(ArrayList<ArrayList<Integer>> adjencyList, Integer a, Integer b) {
        adjencyList.get(a).add(b);
        adjencyList.get(b).add(a);
    }

    static void print(ArrayList<ArrayList<Integer>> arrayList) {
        ListIterator<ArrayList<Integer>> iterator = arrayList.listIterator();
        int indexCounter = 0;
        while (iterator.hasNext()) {
            ArrayList<Integer> t = iterator.next();
            System.out.print(" Node vertex list for " + indexCounter++ + " --> ");

            t.stream().forEach(r -> System.out.print(r));
            System.out.println();
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        add(adjacencyList, 0, 1);
        add(adjacencyList, 1, 2);
        add(adjacencyList, 2, 4);
//        add(adjacencyList, 2, 5);
        add(adjacencyList, 5, 4);
        add(adjacencyList, 1, 3);

        // print(adjacencyList);

        boolean[] visited = new boolean[6];
//        dfs(adjacencyList, 1, visited);

        // bfs(adjacencyList, 0, visited);

        Stack<Integer> integerStack = new Stack<>();
        dfs_topologicalSort(adjacencyList, 0, visited, integerStack);

        while (!integerStack.isEmpty()) {
            System.out.println(" " + integerStack.pop());
        }
    }

    //              4
    //  0 -----1----2
    //         3 ---5

    static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int source, boolean[] visited) {
        visited[source] = true;
        System.out.println(" -- " + source);

        for (int e : adjacencyList.get(source)) {
            if (visited[e] == false) {
                dfs(adjacencyList, e, visited);
            }
        }
    }

    static void dfs_topologicalSort(ArrayList<ArrayList<Integer>> adjacencyList, int source, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
       // System.out.println(" -- " + source);

        for (int e : adjacencyList.get(source)) {
            if (visited[e] == false) {
                dfs_topologicalSort(adjacencyList, e, visited, stack);
            }
        }

        stack.push(source);
    }

    static void bfs(ArrayList<ArrayList<Integer>> adjacencyList, int source, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {

            Integer data = queue.poll();
            System.out.print("--->>" + data);
            visited[data] = true;

            for (Integer i : adjacencyList.get(data)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
