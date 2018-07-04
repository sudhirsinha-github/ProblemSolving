package dynamicpg.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String data;
    private boolean isVisited;
    private boolean isBeingVisited;
    private List<Vertex> myNeighboursList;

    public Vertex(String data) {
        this.data = data;
        this.myNeighboursList = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isBeingVisited() {
        return isBeingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        isBeingVisited = beingVisited;
    }

    public List<Vertex> getMyNeighboursList() {
        return myNeighboursList;
    }

    public void setMyNeighboursList(Vertex myNeighbour) {
        this.myNeighboursList.add(myNeighbour);
    }

    @Override
    public String toString() {
        return this.data;
    }
}
