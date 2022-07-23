package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversals {
    class Pair{
        TreeNode key;
        int value;
        Pair(TreeNode key, int value){
            this.key=key;
            this.value=value;
        }
    }
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

    public void allTraversals(TreeNode root){
        Stack<Pair> st= new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        if (root==null) return;

        while (!st.isEmpty()){
            Pair it=st.pop();

            //for preorder list
            //increment 1 to 2
            //push the left side of the tree
            if (it.value==1){
                pre.add(it.key.val);
                it.value++;
                st.push(it);

                if (it.key.left!=null){
                    st.push(new Pair(it.key.left,1));
                }
            }

            //for inorder list
            //increment 2 to 3
            //push right
            else if(it.value==2){
                in.add(it.key.val);
                it.value++;
                st.push(it);

                if(it.key.right!=null){
                    st.push(new Pair(it.key.right,1));
                }
            }

            //for post order
            //don't push it back again
            else{
                post.add(it.key.val);
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        AllTraversals a=new AllTraversals();
        a.allTraversals(root);
    }
}
