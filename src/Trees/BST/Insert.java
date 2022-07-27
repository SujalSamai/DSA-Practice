package Trees.BST;

import Trees.Implementation.TreeNode;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Insert {
    public TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
        if (root==null) return new TreeNode(val);
        TreeNode<Integer> cur=root;
        while (true){
            if (cur.val<=val){
                if (cur.right!=null) cur=cur.right;
                else {
                    cur.right=new TreeNode<>(val);
                    break;
                }
            }else {
                if (cur.left!=null) cur=cur.left;
                else {
                    cur.left=new TreeNode<>(val);
                    break;
                }
            }
        }
        return root;
    }
}
