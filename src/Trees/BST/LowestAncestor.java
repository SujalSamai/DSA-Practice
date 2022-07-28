package Trees.BST;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
import Trees.Implementation.TreeNode;

public class LowestAncestor {
    public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root == null) return null;
        int curr = root.val;
        if(curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
