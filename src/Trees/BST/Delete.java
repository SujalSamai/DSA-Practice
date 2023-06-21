package Trees.BST;
//https://leetcode.com/problems/delete-node-in-a-bst/
import Trees.Implementation.TreeNode;

public class Delete {
    public TreeNode<Integer> deleteNode(TreeNode<Integer> root, int key) {
        if (root==null){
            return null;
        }
        //if the root has to be deleted
        //make the left of node, the new root and point its right to previous root's right
        if (root.val==key){
            return helper(root);
        }
        TreeNode<Integer> dummy=root;
        while (root!=null){
            //element present at left of root
            if (root.val>key){
                if (root.left!=null && root.left.val==key){
                    //helper function makes the tree again a bst by making new connection after deleting the particular key
                    root.left=helper(root.left);
                    break;
                }else {
                    root=root.left;
                }
            }else{ //element present at right of root
                if (root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }else {
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode<Integer> helper(TreeNode<Integer> root) {
        //if left side doesn't have elements, join the root with the right side and vice versa
        if (root.left==null){
            return root.right;
        }else if (root.right==null){
            return root.left;
        }else {
            //store the right subtree of the root
            TreeNode<Integer> rightChild= root.right;
            //find the rightest node of the left subtree
            TreeNode<Integer> lastRight= findLastRight(root.left);
            //attach thr right subtree to the rightest node of left subtree
            lastRight.right=rightChild;
            return root.left;
        }
    }

    //keep on going to right until encounters null
    private TreeNode<Integer> findLastRight(TreeNode<Integer> root) {
        if (root.right==null){
            return root;
        }
        return findLastRight(root.right);
    }
}
