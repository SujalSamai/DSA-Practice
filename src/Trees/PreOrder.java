package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Root left right - O(N)
    List<Integer> ls= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return ls;
        }
        ls.add(root.val);
        ls=preorderTraversal(root.left);
        ls=preorderTraversal(root.right);
        return ls;
    }

    public List<Integer> preorderTraversalIterative(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> lst=new ArrayList<>();
        if(root==null){
            return lst;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            lst.add(root.val);
            //The right child is pushed before the left child to make sure that the left subtree is processed first.
            //As stack is LIFO
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        PreOrder traverse=new PreOrder();
        System.out.println(traverse.preorderTraversalIterative(root));
    }
}
