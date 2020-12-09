import java.util.*;

public class CloneGraph {
    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<Node> nodes = getNode(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<Node, Node> mapping = new HashMap<>();
        for (Node n: nodes) {
            mapping.put(n, new Node(n.val));
        }

        // copy neighbors(edges)

        for (Node n : nodes) {
            Node newNode = mapping.get(n);
            for (Node neighbor: n.neighbors){
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    private ArrayList<Node> getNode(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor: cur.neighbors) {
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(visited);
    }
}
