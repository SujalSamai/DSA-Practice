package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
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

    //Left Root Right
    List<Integer> ls= new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return ls;
        }
        ls=inorderTraversal(root.left);
        ls.add(root.val);
        ls=inorderTraversal(root.right);
        return ls;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root){
        List<Integer> list= new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else {
                if (stack.isEmpty()){
                    break;
                }
                node=stack.pop();
                list.add(node.val);
                node=node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        InOrder traverse=new InOrder();
        System.out.println(traverse.inorderTraversal(root));
    }
}
