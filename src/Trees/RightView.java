package Trees;

import Trees.Implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightView {

    //We will do a reverse Pre order traversal i.e. we will consider Root, Right and Left
    //at each level, the first node we will encounter, we will print it
    public List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> res=new ArrayList<>();
        rightView(root,res,0);
        return res;
    }
    public void rightView(TreeNode<Integer> cur,List<Integer> res,int curDepth){
        if (cur==null){
            return;
        }
        if (curDepth==res.size()){
            res.add(cur.val);
        }

        rightView(cur.right,res,curDepth+1);
        rightView(cur.left,res,curDepth+1);
    }
}
