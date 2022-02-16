import java.util.*;

public class ProjectingPath {



    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge("siva", "damu");
        graph.addEdge("damu", "x");
        graph.addEdge("x", "z");
        graph.addEdge("siva", "mani");
        graph.addEdge("mani", "a");
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the source point : ");
            String source = s.next();
            System.out.println("Enter the destination point : ");
            String destination = s.next();
            System.out.println("Path connecting between " + source + " and " + destination + " is : ");
            List<String> results = graph.shortestPath(source, destination);

            for (int i = 0; i < (results.size() - 1); i++) {
                System.out.print(results.get(i) + "--->");
            }

            System.out.print(results.get(results.size() - 1));
        }
        catch (Exception e)
        {
            System.out.println("Invalid inputs");

        }
    }
}