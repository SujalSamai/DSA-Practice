package Trees;

import Trees.Implementation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    static class Pair{
        TreeNode<Integer> node;
        int num;
        Pair(TreeNode<Integer> _node, int _num) {
            num = _num;
            node = _node;
        }
    }
    public static int widthOfBinaryTree(TreeNode<Integer> root){
        if (root==null){
            return 0;
        }
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().num;
            int first=0,last=0;
            for (int i = 0; i < size; i++) {
                int cur_id=q.peek().num-mmin;
                TreeNode<Integer> node=q.peek().node;
                q.poll();
                if (i==0) first=cur_id;
                if (i==size-1) last=cur_id;
                if (node.left!=null){
                    q.add(new Pair(node.left, cur_id*2+1));
                }
                if (node.right!=null){
                    q.add(new Pair(node.right, cur_id*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
