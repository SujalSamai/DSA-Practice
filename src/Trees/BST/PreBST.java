package Trees.BST;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
import Trees.Implementation.TreeNode;

public class PreBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode<Integer> bstFromPreorder(int[] arr,int bound, int[] i){
        int index=i[0];  //just a pointer to keep track of each element
        if (index==arr.length || arr[index]>bound) return null;
        TreeNode<Integer> root=new TreeNode(arr[i[0]++]);
        root.left=bstFromPreorder(arr,root.val,i);
        root.right=bstFromPreorder(arr,bound,i);
        return root;
    }
}
