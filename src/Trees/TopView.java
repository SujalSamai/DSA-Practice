package Trees;
import Trees.Implementation.Node;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopView {
    //Just like vertical order question, we have coordinates with each node
    //at each vertical level, we will print only the first node we can see at that level
    //i.e. at each level print the node having the minimum y coordinate
    static class Pair{
        Node key;
        int value;
        Pair(Node key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans= new ArrayList<>();
        if (root==null) return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            Pair it= q.remove();
            int hd=it.value;
            Node temp=it.key;
            if (map.get(hd)==null) map.put(hd,temp.data);
            if (temp.left!=null) {
                q.add(new Pair(temp.left,hd-1));
            }
            if (temp.right!=null){
                q.add(new Pair(temp.right, hd+1));
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
