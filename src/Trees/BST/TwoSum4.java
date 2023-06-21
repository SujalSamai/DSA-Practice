package Trees.BST;
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst
import Trees.Implementation.TreeNode;

import java.util.ArrayList;

public class TwoSum4 {
    public boolean findTarget(TreeNode<Integer> root, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int left=0, right=arr.size()-1, sum=0;
        while(left<right)
        {
            sum=arr.get(left)+arr.get(right);
            if(sum==k)
                return true;
            else if(sum>k)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return false;
    }

    private void inorder(TreeNode<Integer> root, ArrayList<Integer> arr) {
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}
