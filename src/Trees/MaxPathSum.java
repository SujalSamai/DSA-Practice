package Trees;

import Trees.Implementation.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {

    //find out the maximum sum from left and right at every node and add it to the current node's value
    //this way we get maximum sum a particular node can fetch
    //now find the maximum of all the node's result
    //Note -> if we encounter a negative sum on left or right, we return 0 instead of negative value
    public int maxPathSum(TreeNode<Integer> root) {
        //taking an array, as we can't pass references in java
        int[] maxValue = new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }

    private int maxPathDown(TreeNode<Integer> root, int[] maxValue) {
        if (root==null) return 0;
        int left=Math.max(0, maxPathDown(root.left,maxValue));
        int right=Math.max(0, maxPathDown(root.right,maxValue));
        maxValue[0]=Math.max(maxValue[0],left+right+ root.val);
        return Math.max(left,right)+root.val;
    }
}
