import java.util.*;

public class Dijkstra {
    // instance variables
    private int dist[]; // an array to hold the shortest distance to each vertex from the source vertex
    private int parent[]; // an array to hold the parent vertex of each vertex on the shortest path
    private Set<Integer> visited; // a set to keep track of visited vertices
    private PriorityQueue<Node> pq; // a priority queue to hold vertices based on their distance from the source vertex
    private int V; // the number of vertices in the graph
    List<List<Node>> adj; // the adjacency list of the graph

    // constructor
    public Dijkstra(int V) {
        this.V = V;
        dist = new int[V];
        parent = new int[V];
        visited = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node()); // initialize the priority queue with capacity V and a new Node comparator
    }

    // Dijkstra's shortest path algorithm
    public void dijkstra(List<List<Node>> adj, int src, int dest) {
        this.adj = adj;

        // initialize dist and parent arrays for all vertices
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        pq.add(new Node(src, 0)); // add the source vertex to the priority queue with distance 0
        dist[src] = 0; // set the distance of the source vertex to 0

        // main loop of the algorithm
        while (!pq.isEmpty()) {
            int u = pq.poll().node; // get the vertex with the minimum distance from the priority queue

            visited.add(u); // mark the vertex as visited

            if (u == dest) {
                // backtrack to construct the shortest path
                List<Integer> path = new ArrayList<Integer>();
                while (parent[u] != -1) {
                    path.add(u);
                    u = parent[u];
                }
                path.add(u);
                Collections.reverse(path); // reverse the list to get the correct order
                System.out.println("Shortest path: " + path);
                return; // we have found the shortest path, so we can return
            }

            e_Neighbours(u); // check the neighbours of the current vertex
        }
    }

    // helper method to check the neighbours of a vertex
    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // loop through the neighbours of the current vertex
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // check if the neighbour has not been visited yet
            if (!visited.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // check if the new distance to the neighbour is less than its current distance
                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                    parent[v.node] = u; // set the parent of the neighbour to the current vertex
                }

                pq.add(new Node(v.node, dist[v.node])); // add the neighbour to the priority queue with its updated distance
            }
        }
    }
}
