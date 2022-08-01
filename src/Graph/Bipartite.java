package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/
public class Bipartite {

    //if a graph have odd length cycle then it is not Bipartite
    //if it doesn't have odd length cycle then it is bipartite, doesn't matter if it contains a cycle or not
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for (int i = 0; i < n; i++) {
            if (color[i]==-1){
                if (!bfsCheck(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfsCheck(int[][] graph,int node, int[] color){
        Queue<Integer> q=new LinkedList<>();
        color[node]=1;
        q.add(node);
        while (!q.isEmpty()){
            int curr=q.poll();
            for (int neighbour:graph[curr]){
                if (color[neighbour]==-1){
                    color[neighbour]=1-color[curr];
                    q.add(neighbour);
                }else if(color[neighbour]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfsCheck(int[][] graph, int node, int[] color){
        for (int neighbour: graph[node]){
            if (color[neighbour]==-1){
                color[neighbour]=1-color[node];
                if (!dfsCheck(graph,neighbour,color)){
                    return false;
                }
            }else if(color[neighbour]==color[node]){
                return false;
            }
        }
        return true;
    }
}
