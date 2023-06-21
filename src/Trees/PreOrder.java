package Trees;

import Trees.Implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    //Root left right - O(N)
    List<Integer> ls= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode<Integer> root) {
        if(root==null){
            return ls;
        }
        ls.add(root.val);
        ls=preorderTraversal(root.left);
        ls=preorderTraversal(root.right);
        return ls;
    }

    public List<Integer> preorderTraversalIterative(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack=new Stack<>();
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
        TreeNode<Integer> root= new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        PreOrder traverse=new PreOrder();
        System.out.println(traverse.preorderTraversalIterative(root));
    }
}
