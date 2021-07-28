package dynamicpg.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private Queue<Vertex> vertexQueue;

    public BFS() {
        this.vertexQueue = new LinkedList<>();
    }

    public void bfs(List<Vertex> vertexList)
    {
        for ( Vertex vertex:vertexList) { // this is to take care for cluster meaning disconnected nodes pair
            if(!vertex.isVisited())
            {
                vertex.setVisited(true);
                bfsWithQueue(vertex);
            }
        }
    }

    private void bfsWithQueue(Vertex parentVertex) {
        vertexQueue.add(parentVertex); // push the parentVertex

        // make parentVertex set visited true
        parentVertex.setVisited(true);
        while (!vertexQueue.isEmpty()) {
            Vertex vertex = vertexQueue.poll();
            System.out.print(vertex +"`");

            for (Vertex mychilds : parentVertex.getMyChild()) {
                if (!mychilds.isVisited())
                {
                    mychilds.setVisited(true);
                    vertexQueue.add(mychilds);
                }
            }
        }
    }
}
