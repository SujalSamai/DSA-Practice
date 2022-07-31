package Graph.Implementation;
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
import java.util.ArrayList;

public class DFS {
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> storeDFS=new ArrayList<>();
        boolean[] vis=new boolean[V]; //boolean array to keep track of visited vertices

        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dfs(i,vis,adj,storeDFS);
            }
        }
        return storeDFS;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDFS) {
        if(vis[node]){
            return;
        }
        storeDFS.add(node);
        //marking current node as visited
        vis[node]=true;

        //getting neighbour nodes
        for (Integer it: adj.get(node)){
            if (!vis[it]){
                dfs(it,vis,adj,storeDFS);
            }
        }
    }
}
