package Trees.BST;

import Trees.Implementation.TreeNode;

public class ValidateBST {
    private boolean checkBST(TreeNode<Integer> node, long min, long max) {
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;

        if(checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
            return true;
        }
        return false;
    }
    public boolean isValidBST(TreeNode<Integer> root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
