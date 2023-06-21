package Recursion;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class MColoring {
    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color=new int[n];
        Arrays.fill(color,-1);

        return backtracking(0,graph,m,n,color);
    }

    private boolean backtracking(int curr, boolean[][] graph, int m, int n, int[] color) {
        if (curr==n){
            return true;
        }

        for (int i = 0; i < m; i++) {
            if (isSafe(graph,curr,i,color)){
                color[curr]=i;
                if (backtracking(curr+1,graph,m,n,color)){
                    return true;
                }
                color[curr]=-1;
            }
        }
        return false;
    }

    private boolean isSafe(boolean[][] graph, int curr, int assign, int[] color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[curr][i] && color[i]==assign){
                return false;
            }
        }
        return true;
    }
}
