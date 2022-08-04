package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Spanning Tree-> If a tree having N nodes and N-1 edges can be drawn from a given graph, such that every node can be reached by any other node
public class PrimsAlgorithm {
    /* Prim's Algorithm: Take the initial node and take the min edge it has and reach the next node from it
    Now take both the nodes and find the min edge from both the nodes and reach next node from it
    Repeat the steps until all nodes has been reached
    Note: Make sure the minimal edge doesn't form a cycle, if it does ignore that edge
     */
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
        }
    }
//    TC-O(ElogE) SC-O(E+V)
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean[] vis=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int ans=0;
        while (pq.size()!=0){
            Pair cur= pq.remove();
            int node=cur.v;
            if (vis[node]){
                continue;
            }
            ans+=cur.wt;
            vis[node]=true;
            ArrayList<ArrayList<Integer>> neighbours=adj.get(node);
            for (ArrayList<Integer> list:neighbours){
                int vertex= list.get(0);
                int wt=list.get(1);
                if (!vis[vertex]){
                    pq.add(new Pair(vertex,wt));
                }
            }
        }
        return ans;
    }

}
