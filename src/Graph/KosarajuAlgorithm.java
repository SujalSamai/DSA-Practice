package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
    //Sort all nodes in order of finishing time i.e. do topological sort
    //Transpose the graph, that is reverse the edges' direction
    //DFS according to the finishing time of nodes
    static void kosaraju(ArrayList<ArrayList<Integer>> adj, int n){
        int[] vis=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                dfs(i,stack,adj,vis);
            }
        }
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            vis[i]=0;
            for (Integer it:adj.get(i)){
                transpose.get(it).add(i);
            }
        }

        while(stack.size() > 0) {
            int node = stack.peek();
            stack.pop();
            if(vis[node] == 0) {
                System.out.print("SCC: ");
                revDFS(node, transpose, vis);
                System.out.println();
            }
        }

    }

    private static void revDFS(int node, ArrayList<ArrayList<Integer>> transpose, int[] vis) {
        vis[node]=1;
        System.out.print(node+" ");
        for (Integer it: transpose.get(node)){
            if (vis[it]==0){
                revDFS(it,transpose,vis);
            }
        }
    }

    private static void dfs(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node]=1;
        for (Integer it:adj.get(node)){
            if (vis[it]==0){
                dfs(it,stack,adj,vis);
            }
        }
        stack.push(node);
    }


    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(6).add(5);

        kosaraju(adj,n);
    }

}
