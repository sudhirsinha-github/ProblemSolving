package dynamicpg.dfs;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5"); // cntrol + command +G  for multiple lines edit
        Vertex vertex6 = new Vertex("6"); // cntrol + command +G  for multiple lines edit
        //Vertex vertex7 = new Vertex("7"); // cntrol + command +G  for multiple lines edit

        List<Vertex> vertices = new ArrayList<>();
        //vertex3.addChild(vertex7);
        vertex1.addChild(vertex2);
        vertex1.addChild(vertex3);
        vertex2.addChild(vertex4);
        vertex2.addChild(vertex5);
        vertex5.addChild(vertex6);

        //add all nodes to list now ..
        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);
        vertices.add(vertex4);
        vertices.add(vertex5);
        vertices.add(vertex6);
        // vertices.add(vertex7);

        DFS dfs = new DFS();
        dfs.dfs(vertices);

        System.out.println("====  ==== ");
//        BFS bfs = new BFS();
//        bfs.bfs(vertices);
    }
}