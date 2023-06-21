package Trees;

import Trees.Implementation.TreeNode;

public class SymmetricBT {
    //property of mirror=> left side will change to right side and right side will change to left side
    //we will do pre order traversal on both subtrees, on left we will do Root Left Right, on right we'll do Root Right Left
    public boolean isSymmetric(TreeNode<Integer> root) {
        return root==null || isSymmetricHelp(root.left,root.right);
    }

    private boolean isSymmetricHelp(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left==null || right==null){
            return left==right;
        }

        if (left.val!=right.val) return false;

        return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right, right.left);
    }
}
