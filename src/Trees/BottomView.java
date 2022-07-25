package Trees;

import Trees.Implementation.Node;

import java.util.*;

public class BottomView {
    //just opposite of TopView
    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if (root==null) return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        root.hdistance=0;
        q.add(root);
        while (!q.isEmpty()){
            Node temp=q.remove();
            int hd= temp.hdistance;
            map.put(hd, temp.data);
            if (temp.left!=null){
                temp.left.hdistance=hd-1;
                q.add(temp.left);
            }
            if (temp.right!=null){
                temp.right.hdistance=hd+1;
                q.add(temp.right);
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
