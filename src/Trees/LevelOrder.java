package Trees;

import Trees.Implementation.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue=new LinkedList<TreeNode<Integer>>();
        List<List<Integer>> list=new LinkedList<List<Integer>>();

        if (root==null){
            return list;
        }
        //Add the root element
        queue.add(root);
        while (!queue.isEmpty()){
            //finding the number of elements at each level
            int level= queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for (int i = 0; i < level; i++) {
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}
