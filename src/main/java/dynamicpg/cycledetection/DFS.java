package dynamicpg.cycledetection;

import java.util.List;

public class DFS {

    public void dfs(List<Vertex> vertices)
    {
        for (Vertex vertex:vertices) {
            if(!vertex.isVisited()) {
                dfsWithStack(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex parentVertex) {
        parentVertex.setBeingVisited(true);

            for (Vertex mychilds : parentVertex.getMyNeighboursList()) {

                if(!mychilds.isBeingVisited())
                {
                    System.out.println("loop was found -- " + mychilds.toString());
                    return;
                }

                if (!mychilds.isVisited())
                {
                    mychilds.setVisited(true);
                    dfsWithStack(mychilds);
                }
            }


        parentVertex.setBeingVisited(false);
            parentVertex.setVisited(true);
    }
}
