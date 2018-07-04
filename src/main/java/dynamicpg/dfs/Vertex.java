package dynamicpg.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> myChild;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    private boolean isVisited;

    public Vertex(String name) {
        this.name = name;
        this.myChild = new ArrayList<>();
    }

    //add childs to list
    public void addChild(Vertex vertex) {
        this.myChild.add(vertex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getMyChild() {
        return myChild;
    }

    public void setMyChild(List<Vertex> myChild) {
        this.myChild = myChild;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
