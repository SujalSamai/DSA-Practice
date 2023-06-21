package Trees.Implementation;

public class Node {
    public int data;
    public int hdistance;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        hdistance=Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
    }
}
