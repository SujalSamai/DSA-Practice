package Trees;

import Trees.Implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    //left right root
    List<Integer> ls=new ArrayList<>();
    public List<Integer> postOrderTraversal(TreeNode<Integer> root){
        if (root==null){
            return ls;
        }

        ls=postOrderTraversal(root.left);
        ls=postOrderTraversal(root.right);
        ls.add(root.val);
        return ls;
    }

    //using 2 stack
    public List<Integer> postorderTraversalIterative(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> st1= new Stack<>();
        Stack<TreeNode<Integer>> st2= new Stack<>();
        List<Integer> list= new ArrayList<>();

        if (root==null) return list;

        st1.push(root);
        while (!st1.isEmpty()){
            root=st1.pop();
            st2.add(root);
            if (root.left!=null){
                st1.push(root.left);
            }
            if (root.right!=null){
                st1.push(root.right);
            }
        }
        while (!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root= new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        PostOrder traverse=new PostOrder();
        System.out.println(traverse.postOrderTraversal(root));
    }
}
