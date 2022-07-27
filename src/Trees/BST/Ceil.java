package Trees.BST;

import Trees.Implementation.TreeNode;

public class Ceil {
    public static int findCeil(TreeNode<Integer> root, int key){
        int ceil=-1;
        while (root!=null){
            if (root.val==key){
                ceil= root.val;
                return ceil;
            }
            if (key> root.val){
                root=root.right;
            }else{
                ceil= root.val;
                root=root.left;
            }
        }
        return ceil;
    }
}
