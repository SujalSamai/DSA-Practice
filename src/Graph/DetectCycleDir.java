package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    //Kahn's Algorithm
    //We can find topological sort only if it is a Directed Acyclic Graph,
    //which means if we can't find topological sort i.e. count!=N
    //we can say the graph is Cyclic
    public static boolean isCyclicBFS(int N, ArrayList<ArrayList<Integer>> adj){
        int[] topo=new int[N];
        int[] indegree=new int[N];

        for (int i=0; i<N; i++){
            for (Integer it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i=0; i<N; i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        int count=0, index=0;
        while (!q.isEmpty()){
            Integer node=q.poll();
            topo[index++]=node;
            count++;
            //getting neighbour nodes of popped node and decreasing their indegree by 1
            for (Integer it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if (count==N){
            return false;
        }
        return true;
    }
}
