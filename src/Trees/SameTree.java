package Trees;

import Trees.Implementation.TreeNode;

public class SameTree {
    //Just do any Traversal technique for both the trees and check if they are similar

    public boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) return false;

        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);

        return left && right;
    }

    //simple way
    public boolean isSameTree2(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p==null || q==null){
            return (p==q);
        }
        return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
