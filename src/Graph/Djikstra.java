package Graph;
//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Djikstra {
    public static void main(String[] args) {

    }
    //TC- O((N+E)logN) or O(NlogN), SC- O(N)+O(N) or O(N)
    static class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;

        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // visited arr
        boolean[] vis=new boolean[V];
        //min heap priority queue, which compares according to weight
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>();

        //adding source and its distance is always 0
        pq.add(new Pair(S,0));
        int[] ans=new int[V];
        //initiating ans arr, with a max-value
        Arrays.fill(ans,10000000);
        //distance of source is always 0
        ans[S]=0;
        while(pq.size()!=0){
            //taking out the node
            Pair cur=pq.remove();
            int u=cur.v;
            if(vis[u]){ //if already visited
                continue;
            }//else mark it true
            vis[u]=true;
            //all the neighbours of the current node u
            ArrayList<ArrayList<Integer>> neighbours=adj.get(u);
            //for every neighbour of current node
            for(ArrayList<Integer> list:neighbours){
                //take out value and weight
                int vertex=list.get(0);
                int wt=list.get(1);
                //comparing
                if(ans[vertex]>ans[u]+wt){
                    ans[vertex]=ans[u]+wt;
                    pq.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }

}
