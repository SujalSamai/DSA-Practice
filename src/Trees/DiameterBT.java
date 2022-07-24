package Trees;

public class DiameterBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //diameter-> longest path between 2 nodes, may or may not include the root node
    public int diameterOfBinaryTree(TreeNode root){
        int[] diameter= new int[1];
        height(root,diameter);
        return diameter[0];
    }

    private int height(TreeNode root,int[] diameter){
        if (root==null){
            return 0;
        }
        int lh=height(root.left,diameter);
        int rh=height(root.right,diameter);
        diameter[0]=Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}
