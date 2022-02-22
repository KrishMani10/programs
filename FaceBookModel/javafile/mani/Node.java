package mani;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    List<Node> nearPoints = new ArrayList<Node>();

    public Node(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addNearPoint(Node nearPoint)
    {
        if(!nearPoints.contains(nearPoint)) {


            nearPoints.add(nearPoint);
        }
    }

    public List<Node> getNearPoints(){
        return nearPoints;
    }

    public String toString()
    {
        return this.name;
    }
}