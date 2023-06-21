package Trees.BST;

import Trees.Implementation.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode<Integer> root, int val) {
        while(root!=null && root.val!=val){
            root= val< root.val ? root.left : root.right;
        }
        return root;
    }
}
