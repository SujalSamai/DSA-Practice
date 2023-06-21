package Graph.Implementation;
//https://practice.geeksforgeeks.org/problems/topological-sort/1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Topological Sorting -Linear ordering of values such that if there is an edge u->v, u appears before v in that ordering
//It is possible only for Directed Acyclic Graph
public class TopologicalSorting {
    static void findTopoSort(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=1;
        for (Integer it: adj.get(node)){
            if (vis[it]==0){
                findTopoSort(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[N];
        for (int i = 0; i < N; i++) {
            if (vis[i]==0){
                findTopoSort(i,vis,adj,st);
            }
        }

        int[] topo=new int[N];
        int index=0;
        while (!st.isEmpty()){
            topo[index++]=st.pop();
        }
        return topo;
    }

    //Kahn's Algorithm
    //Find the indegree(no. of edges directing to the node) for all the nodes and store it in an array
    //For the nodes having indegree=0, put them in queue.
    //Pop one node from queue, print it and decrement the indegree value of its adjacents
    //if any of the adjacent in indegree arr becomes 0, put in the queue and repeat the steps till all the indegree becomes zero and queue is empty
    public static int[] topoSortBFS(int N, ArrayList<ArrayList<Integer>> adj){
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
        return topo;
    }
}
