import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            int V = 6;
            int source = 0;
            int dest = 5;

            List<List<Node>> adj = new ArrayList<List<Node>>();
            for (int i = 0; i < V; i++) {
                List<Node> item = new ArrayList<Node>();
                adj.add(item);
            }

            adj.get(0).add(new Node(1, 1));
            adj.get(0).add(new Node(2, 1));
            adj.get(1).add(new Node(3, 1));
            adj.get(1).add(new Node(2, 1));
            adj.get(2).add(new Node(4, 1));
            adj.get(2).add(new Node(5, 1));
            adj.get(2).add(new Node(3, 1));
            adj.get(3).add(new Node(4, 1));
            adj.get(4).add(new Node(5, 1));
            for(List<Node> i : adj){
                System.out.println(i);
            }

            Dijkstra dpq = new Dijkstra(V);
            dpq.dijkstra(adj, source, dest);
        }
    }