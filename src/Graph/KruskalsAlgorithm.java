package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//sort all edges wrt its weight, and take one by one edge
//find if its nodes belong to same component or not, if not join them and change one of them's parent
//if they belong to same component, ignore that edge, otherwise it'll create a cycle and we won't get tree
//repeat these steps until you have checked all the edges
//TC- approx. O(NlogN) SC- approx. O(N)-> more efficient than Prim's Algo
public class KruskalsAlgorithm {
    static class Node{
        private int u,v,weight;
        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        Node(){}
        int getV(){return v;}
        int getWeight(){return weight;}
        int getU(){return u;}
    }
    private static class SortComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2){
            if (node1.getWeight()< node2.getWeight()) return -1;
            if (node1.getWeight()> node2.getWeight()) return 1;
            return 0;
        }
    }
    static void kruskalAlgo(ArrayList<Node> adj, int N){
        Collections.sort(adj,new SortComparator());
        int[] parent=new int[N];
        int[] rank=new int[N];

        for (int i = 0; i < N; i++) {
            parent[i]=i;
            rank[i]=0;
        }

        int cost=0;
        ArrayList<Node> mst=new ArrayList<>();
        for (Node it:adj){
            if (findParent(it.getU(),parent)!=findParent(it.getV(),parent)){
                cost+=it.getWeight();
                mst.add(it);
                union(it.getU(),it.getV(),parent,rank);
            }
        }
        System.out.println("Minimum Cost of Spanning Tree: "+cost);
        System.out.println("Edges in the MST:");
        for (Node it:mst){
            System.out.println(it.getU()+" - "+it.getV());
        }
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u=findParent(u,parent);
        v=findParent(v,parent);
        if (rank[u]<rank[v]){
            parent[u]=v;
        }else if (rank[v]<rank[u]){
            parent[v]=u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }

    private static int findParent(int u, int[] parent) {
        if (u==parent[u]) return u;
        return parent[u]=findParent(parent[u],parent);
    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        kruskalAlgo(adj,n);
    }

}
