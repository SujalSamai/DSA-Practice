package Trees;
//https://leetcode.com/problems/invert-binary-tree
import Trees.Implementation.TreeNode;

public class InvertBT {
    public TreeNode invertTree(TreeNode root){
        if (root==null){
            return root;
        }
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;

        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}
