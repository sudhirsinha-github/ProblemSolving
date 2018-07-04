package dynamicpg.cycledetection;

import dynamicpg.cycledetection.DFS;
import dynamicpg.cycledetection.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5"); // cntrol + command +G  for multiple lines edit
        Vertex vertex6 = new Vertex("6"); // cntrol + command +G  for multiple lines edit
        //Vertex vertex7 = new Vertex("7"); // cntrol + command +G  for multiple lines edit

        List<Vertex> vertices = new ArrayList<>();
        //vertex3.setMyNeighboursList();(vertex7);
        vertex1.setMyNeighboursList(vertex2);
        vertex1.setMyNeighboursList(vertex3);
        vertex2.setMyNeighboursList(vertex4);
        vertex2.setMyNeighboursList(vertex5);
        vertex5.setMyNeighboursList(vertex6);
        vertex6.setMyNeighboursList(vertex1);

        //add all nodes to list now ..
        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);
        vertices.add(vertex4);
        vertices.add(vertex5);
        vertices.add(vertex6);

        DFS dfs = new DFS();
        dfs.dfs(vertices);
    }
}
