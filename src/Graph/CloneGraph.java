package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    static class Node {
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
    public static HashMap<Integer,Node> map=new HashMap<>();
    static public Node cloneGraph(Node node) {
        if (node==null) return null;
        if (map.containsKey(node.val)){
            return map.get(node.val);
        }

        //creating a new node for the current node, it contains current node value and an empty list
        Node newNode=new Node(node.val,new ArrayList<Node>());
        //map the curr node's value to the newNode
        map.put(node.val, newNode);

        //now we will traverse the neighbours present in the curr node and recursively add it to the newNode's list
        for (Node neighbour: node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbour));
        }
        return newNode;
    }
}
