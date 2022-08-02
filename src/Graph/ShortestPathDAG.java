package Graph;

import java.util.ArrayList;
import java.util.Stack;

//using Topological Sorting
public class ShortestPathDAG {
    static class Pair{
        int value;
        int weight;

        public Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        int getValue(){return value;}
        int getWeight(){return weight;}
    }
    void shortestPath(int src,ArrayList<ArrayList<Pair>> adj, int N){
        Stack<Integer> st=new Stack<>();
        int[] dist=new int[N];
        boolean[] vis=new boolean[N];
        for (int i=0; i<N; i++){
            vis[i]=false;
        }
        for (int i=0;i<N; i++){
            if (!vis[i]){
                topologicalSort(i,vis,st,adj);
            }
        }
        for (int i=0;i<N; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        while (!st.isEmpty()){
            int node=st.pop();
            if (dist[node]!=Integer.MAX_VALUE){
                for (Pair it:adj.get(node)){
                    if (dist[node]+it.getWeight()<dist[it.getValue()]){
                        dist[it.getValue()]=dist[node]+it.getWeight();
                    }
                }
            }
        }
    }

    private void topologicalSort(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        vis[node]=true;
        for (Pair it:adj.get(node)){
            if (!vis[it.getValue()]){
                topologicalSort(it.getValue(),vis,st,adj);
            }
        }
        st.add(node);
    }
}
