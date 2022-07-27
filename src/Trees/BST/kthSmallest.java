package Trees.BST;

import Trees.Implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class kthSmallest {
    //Imp- whenever we do inorder traversal of a BST, the result comes always in sorted order
    int count, ans;
    public int kthSmallest(TreeNode<Integer> root, int k) {
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        return list.get(k - 1);
        count = 0;
        inorder(root, k);
        return ans;
    }
    private boolean inorder(TreeNode<Integer> root, int k){
        if (root==null){
            return false;
        }
        if (inorder(root.left,k)){
            return true;
        }
        count++;
        if (count==k){
            ans= root.val;
            return true;
        }
        return inorder(root.right, k);
    }
    private void inorder(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
