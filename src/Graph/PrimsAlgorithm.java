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
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        PrimsAlgorithm obj = new PrimsAlgorithm();
        int sum = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
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
