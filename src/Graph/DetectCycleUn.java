package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//using BFS
public class DetectCycleUn {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        for (int i = 0; i < V; i++) {
            if (vis[i]==false){
                if (checkForCycle(adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(s,-1));
        vis[s]=true;

        while (!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();

            for (Integer it:adj.get(node)){
                if (vis[it]==false){
                    q.add(new Pair(it,node));
                    vis[it]=true;
                }else if(par!=it) return true;
            }
        }
        return false;
    }
}
