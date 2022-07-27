package Trees;

import Trees.Implementation.TreeNode;

public class LowestCommonAncestor {

    //We will traverse the tree, searching for both the nodes, in whichever branch we will encounter the nodes, we return the value
    //if we find null in a branch we return null
    //the node point at which, both from left and right, we are getting required nodes and not null is our NCA
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode<Integer> left=lowestCommonAncestor(root.left,p,q);
        TreeNode<Integer> right=lowestCommonAncestor(root.right, p, q);

        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        else{   //if none of them are null, we found our result
            return root;
        }
    }
}
