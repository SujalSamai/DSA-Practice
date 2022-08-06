package Graph;

import java.util.ArrayList;
//An edge in an undirected connected graph is a bridge if removing it disconnects the graph.
//For a disconnected undirected graph, definition is similar, a bridge is an edge removing which increases number of disconnected components.
public class BridgesInGraph {
    void printBridges(ArrayList<ArrayList<Integer>> adj, int n){
        int[] vis=new int[n]; //visited
        int[] tin=new int[n]; //time of insertion
        int[] low=new int[n]; //low time

        int timer=0;
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                dfs(i,-1,vis,tin,low,adj,timer);
            }
        }
    }

    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, int timer) {
        vis[node]=1;
        tin[node]=low[node]=timer++;

        for (Integer it:adj.get(node)){
            if (it==parent) continue;
            if (vis[it]==0){
                dfs(it,node,vis,tin,low,adj,timer);
                low[node]=Math.min(low[node],low[it]);

                if (low[it]>tin[node]){
                    System.out.println(it + " "+ node);
                }
            }else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
    }
}
