package dynamicpg.dfs;

import java.util.List;
import java.util.Stack;

public class DFS {
    private Stack<Vertex> vertexStack;

    public DFS() {
        this.vertexStack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList)
    {
        for ( Vertex vertex:vertexList) { // this is to take care for cluster meaning disconnected nodes pair
            if(!vertex.isVisited())
            {
                vertex.setVisited(true);
                dfsWithStack(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex parentVertex) {
        vertexStack.push(parentVertex); // push the parentVertex

        // make parentVertex set visited true
        parentVertex.setVisited(true);
        while (!vertexStack.isEmpty()) {
            Vertex vertex = vertexStack.pop();
            System.out.print(vertex +"`");

            for (Vertex mychilds : parentVertex.getMyChild()) {
                if (!mychilds.isVisited())
                {
                    mychilds.setVisited(true);
                    vertexStack.push(mychilds);
                }
            }
        }
    }
}
