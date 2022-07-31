package Graph;

import java.util.ArrayList;

//using DFS
public class DetectCycleDir {
    public static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int [] dfsVis){
        vis[node] = 1;
        dfsVis[node] = 1;

        for(Integer neighbor: adj.get(node)) {
            if(vis[neighbor] == 0) {
                if(checkCycle(neighbor, adj, vis, dfsVis)) {
                    return true;
                }
            } else if(dfsVis[neighbor] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[N];
        int[] dfsVis = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis)) return true;
            }
        }
        return false;
    }
}
