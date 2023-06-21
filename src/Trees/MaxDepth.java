package Trees;

import Trees.Implementation.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode<Integer> root){
        if (root==null){
            return 0;
        }
        int lh=maxDepth(root.left);
        int rh= maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }
}
