import java.util.*;

public class Dijkstra {
    private int dist[];
    private int parent[];
    private Set<Integer> visited;
    private PriorityQueue<Node> pq;
    private int V; // number of vertices
    List<List<Node>> adj;

    public Dijkstra(int V) {
        this.V = V;
        dist = new int[V];
        parent = new int[V];
        visited = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int src, int dest) {
        this.adj = adj;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        pq.add(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().node;

            visited.add(u);

            if (u == dest) {
                // backtrack to construct the shortest path
                List<Integer> path = new ArrayList<Integer>();
                while (parent[u] != -1) {
                    path.add(u);
                    u = parent[u];
                }
                path.add(u);
                Collections.reverse(path);
                System.out.println("Shortest path: " + path);
                return;
            }

            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            if (!visited.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                    parent[v.node] = u;
                }

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}