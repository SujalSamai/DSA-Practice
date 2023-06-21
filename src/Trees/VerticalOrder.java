package Trees;

import Trees.Implementation.TreeNode;

import java.util.*;

public class VerticalOrder {
    class Tuple{
        TreeNode<Integer> node;
        int row,col;
        public Tuple(TreeNode node, int row, int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode<Integer> root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while (!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode<Integer> node=tuple.node;
            int x=tuple.row;
            int y= tuple.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.val);
            if (node.left!=null){
                q.add(new Tuple(node.left,x-1,y+1));
            }
            if (node.right!=null){
                q.add(new Tuple(node.right,x+1, y+1));
            }
        }

        List<List<Integer>> list=new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>>ys:map.values()){
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes:ys.values()){
                while (!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
