package Trees;
//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
import java.util.ArrayList;

public class BoundaryTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    //Anti-clockwise methoda
    //do left boundary traversal excluding leaf nodes
    //take the leaf nodes and traverse
    //do right boundary traversal excluding leaf nodes in reverse direction
    static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.data);

        addLeftBoundary(node,ans);
        addLeaves(node,ans);
        addRightBoundary(node,ans);
        return ans;
    }

    private static void addRightBoundary(Node node, ArrayList<Integer> ans) {
        Node cur=node.right;
        ArrayList<Integer> tmp=new ArrayList<>();
        while (cur!=null){
            if (!isLeaf(cur)) tmp.add(cur.data);
            if (cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        int i;
        for (i = tmp.size()-1; i>=0 ; --i) {
            ans.add(tmp.get(i));
        }
    }

    private static boolean isLeaf(Node cur) {
        return (cur.left == null) && (cur.right == null);
    }

    private static void addLeaves(Node node, ArrayList<Integer> ans) {
        if (isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if (node.left!=null) addLeaves(node.left,ans);
        if (node.right!=null) addLeaves(node.right,ans);
    }

    private static void addLeftBoundary(Node node, ArrayList<Integer> ans) {
        Node cur=node.left;
        while (cur!=null){
            if (!isLeaf(cur)) ans.add(cur.data);
            if (cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList < Integer > boundaryTraversal;
        boundaryTraversal = boundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }

    }
}
