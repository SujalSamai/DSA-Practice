package Graph;

import java.util.ArrayList;

public class BellmanFordAlgo {
    //We would use a technique what is known as “Relaxing Edges” wherein we would update our distance array if we
    // find a better solution. We would do this N-1 times.
    //TC-> O(N*E) SC->O(N)
    private static class Node {
        private int v,u,weight;
        public Node(int v, int u, int weight) {
            this.v = v;
            this.u = u;
            this.weight = weight;
        }
        Node(){}
        int getV(){return v;}
        int getU(){return u;}
        int getWeight(){return weight;}
    }
    static void bellmanFord(ArrayList<Node> edges,int N, int src){
        int[] dist=new int[N];
        for (int i = 0; i < N; i++) {
            dist[i]=10000000;
        }
        dist[src]=0;
        for (int i = 0; i < N - 1; i++) {
            for (Node node:edges){
                if (dist[node.getU()]+node.getWeight() < dist[node.getV()]){
                    dist[node.getV()]=dist[node.getU()]+ node.getWeight();
                }
            }
        }

        int fl=0;
        for (Node node:edges){
            if (dist[node.getU()]+ node.getWeight()<dist[node.getV()]){
                fl=1;
                System.out.println("Negative cycle");
                break;
            }
        }
        if (fl==0){
            for (int i = 0; i < N; i++) {
                System.out.println(dist[i]+" ");
                
            }
        }
    }
}
