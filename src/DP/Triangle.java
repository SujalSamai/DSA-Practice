package DP;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    //Memoization TC-> O(N*N) SC-> O(N)+(N*N)
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp= new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(dp,-1);
        }
        return func(0,0,triangle,dp);
    }

    private int func(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i==triangle.size()-1){
            return triangle.get(triangle.size()-1).get(j);
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j) + func(i+1,j,triangle,dp);
        int diag=triangle.get(i).get(j) + func(i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(down,diag);
    }

    //Tabulation TC: O(N*N) SC: O(N)
    public int minimumTotal2(List<List<Integer>> triangle){
        int n= triangle.size();
        int[][] dp=new int[n][n];
        for (int i = 0; i <n; i++) {
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for (int i = n-2; i >=0; i--) {
            for (int j = i; j >=0; j--) {
                int down=triangle.get(i).get(j)+ dp[i+1][j];
                int diag= triangle.get(i).get(j)+ dp[i+1][j+1];
                dp[i][j]=Math.min(down,diag);
            }
        }
        return dp[0][0];
    }

    //Space Optimized
    public int minimumTotal3(List<List<Integer>> triangle){
        int n= triangle.size();
        int[] front=new int[n];
        for (int i = 0; i < n; i++) {
            front[i]= triangle.get(n-1).get(i);
        }

        for (int i = n-2; i >=0 ; i--) {
            int[] curr=new int[n];
            for (int j=i; j>=0; j--){
                int down=triangle.get(i).get(j) + front[j];
                int diag=triangle.get(i).get(j) + front[j+1];
                curr[j]=Math.min(down,diag);
            }
            front=curr;
        }
        return front[0];
    }

}
