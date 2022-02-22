package mani;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    int vertices;
    public Map<String,Node> nodes =new HashMap<>();

    public Graph(int vertices)
    {
        this.vertices = vertices;
    }

    public void addEdge(String name1,String name2) {
        Node node1 = nodes.get(name1);
        if (node1 == null)
        {
            node1 =new Node(name1);
        }

        Node node2 = nodes.get(name2);
        if(node2 == null)
        {
            node2 = new Node(name2);
        }

        node1.addNearPoint(node2);
        node2.addNearPoint(node1);

        nodes.put(name1,node1);
        nodes.put(name2,node2);

    }


    public List<String> projectPath(String startName, String endName) {
        Map<String, String> parents = new HashMap<>();
        List<Node> temp = new ArrayList<>();

        Node start = nodes.get(startName);
        temp.add(start);
        parents.put(startName,null);

        while (temp.size() > 0) {
            Node currentNode = temp.get(0);
            List<Node> neighbors = currentNode.getNearPoints();

            for (int i = 0; i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                String nodeName = neighbor.getName();

                boolean visited = parents.containsKey(nodeName);
                if (visited)
                {
                    continue;
                }
                else
                {
                    temp.add(neighbor);
                    parents.put(nodeName, currentNode.getName());

                    if (nodeName.equals(endName))
                    {
                        return getPath(parents, endName);
                    }
                }
            }
            temp.remove(0);
        }

        return null;
    }

    public List<String> getPath(Map<String, String> parents, String endNodeName) {
        List<String> path = new ArrayList<>();
        String node = endNodeName;
        while (node != null) {
            path.add(0, node);
            String parent = parents.get(node);
            node = parent;
        }
        return path;
    }

}