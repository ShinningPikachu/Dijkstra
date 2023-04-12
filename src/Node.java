import java.util.*;

class Node implements Comparator<Node> {
    public int node;
    public int cost;
    public Node()
    {
    }

    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    // Compare the nodes based on the cost
    public int compare(Node node1, Node node2)
    {
        return node1.cost - node2.cost;
    }
}
