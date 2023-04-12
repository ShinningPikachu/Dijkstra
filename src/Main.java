// Importing required packages
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// Setting up the input graph
        int V = 6; // number of vertices
        int source = 0; // source node
        int dest = 5; // destination node

        // Creating an adjacency list to represent the graph
        List<List<Node>> adj = new ArrayList<List<Node>>();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Adding edges to the graph
        adj.get(0).add(new Node(1, 1));
        adj.get(1).add(new Node(0, 1));
        adj.get(0).add(new Node(2, 1));
        adj.get(2).add(new Node(0, 1));
        adj.get(1).add(new Node(3, 1));
        adj.get(3).add(new Node(1, 1));
        adj.get(1).add(new Node(2, 1));
        adj.get(2).add(new Node(1, 1));
        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));
        adj.get(2).add(new Node(5, 1));
        adj.get(5).add(new Node(2, 1));
        adj.get(2).add(new Node(3, 1));
        adj.get(3).add(new Node(2, 1));
        adj.get(3).add(new Node(4, 1));
        adj.get(4).add(new Node(3, 1));
        adj.get(4).add(new Node(5, 1));
        adj.get(5).add(new Node(4, 1));

        // Printing the adjacency list
        for(List<Node> i : adj){
            for(Node j: i){
                System.out.print(j.node + " ");
            }
            System.out.println("");
        }

        // Running Dijkstra's algorithm on the input graph
        Dijkstra dpq = new Dijkstra(V);
        dpq.dijkstra(adj, source, dest);
    }
}