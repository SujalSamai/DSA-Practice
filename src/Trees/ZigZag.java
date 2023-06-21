package Trees;

import Trees.Implementation.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigZag {
    //like level order traversal
    //flag=0 -> direction= l to r. flag=1 -> direction= r to l
    public List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        if (root==null){
            return list;
        }

        queue.add(root);
        boolean flag=true;
        while (!queue.isEmpty()){
            int level= queue.size();
            List<Integer> subList= new ArrayList<>();
            for (int i = 0; i < level; i++) {
                int index=i;
                if (queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                if (flag==true){
                    subList.add(queue.poll().val);
                }else {
                    subList.add(0,queue.poll().val);
                }
            }
            flag=!flag;
            list.add(subList);
        }
        return list;
    }
}
