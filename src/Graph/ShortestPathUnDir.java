package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Find the shortest path to all the nodes of undirected unweighted graph from given src
//as it is unweighted, we assume all edges have weight=1
public class ShortestPathUnDir {
    public void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src){
        int[] dist=new int[N];
        for (int i=0; i<N; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Integer> q=new LinkedList<>();
        //marking the distance of source as 0, as distance between source from source is zero
        dist[src]=0;
        q.add(src);

        while (!q.isEmpty()){
            int node=q.poll();
            for (Integer it:adj.get(node)){
                if (dist[node]+1<dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
