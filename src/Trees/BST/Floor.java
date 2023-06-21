package Trees.BST;

import Trees.Implementation.TreeNode;

public class Floor {
    public static int floorInBST(TreeNode<Integer> root,int key){
        int floor=-1;
        while (root!=null){
            if (root.val==key){
                floor=root.val;
                return floor;
            }
            if (key> root.val){
                floor= root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
