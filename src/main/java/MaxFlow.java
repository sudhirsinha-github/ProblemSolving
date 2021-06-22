// Java program for implementation of Ford Fulkerson algorithm

import java.util.LinkedList;

class MaxFlowQ
{

    boolean bfs(int V, int rGraph[][], int s, int t, int parent[])
    {

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;


        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph
    int maximumFlowOfGraph(int V, int graph[][], int s, int t)
    {
        int u, v;

        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];

        int max_flow = 0;
        while (bfs(V, rGraph, s, t, parent))
        {
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }

    // Driver program to test above functions
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] startingPoints = {1, 2, 1};
        int[] endpoints = {3, 3, 2};
        int[] cost = {5, 2, 3};
        int[] returnValues = rangeOfCost(3, 3, startingPoints, endpoints, cost, 1);
        System.out.println(returnValues);

    }

    public static int[] rangeOfCost(int input1, int input2, int[] input3, int[] input4, int[] input5,  int input6)
    {
        int[][] graph = new int[input1][input1];
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input1; j++) {
                graph[i][j]=0;

            }
        }

        for(int i=0; i<input1; i++){
            int ith = input3[i]-1;
            int jth = input4[i]-1;
            graph[ith][jth] = input5[i];
        }

        MaxFlowQ m = new MaxFlowQ();

        int minimum = m.maximumFlowOfGraph(input1, graph, input6-1, input2 - 1);
        System.out.println("The maximum possible flow is " +
                minimum);

        return new int[]{minimum, Integer.MAX_VALUE};
    }
}