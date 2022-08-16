package DP;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-path-sum/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return minPath(n-1,m-1,grid,dp);
    }

    //memoization - Time Complexity: O(N*M)
    //Space Complexity: O((M-1)+(N-1)) + O(N*M)
    private int minPath(int i, int j, int[][] grid, int[][] dp) {
        if (i==0 && j==0) return grid[0][0];
        if (i<0 || j<0) return Integer.MAX_VALUE;
        if (dp[i][j]!=-1) return dp[i][j];

        int up=grid[i][j]+ minPath(i-1, j, grid, dp);
        int left=grid[i][j]+ minPath(i, j-1, grid, dp);
        return dp[i][j]=Math.min(up,left);
    }

    //tabulation -Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    public int minPathSum2(int[][] grid){
        int n= grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (i==0 && j==0) dp[i][j]=grid[i][j];
                else {
                    int up=grid[i][j];
                    if (i>0) up+=dp[i-1][j];
                    else up+=Integer.MAX_VALUE;

                    int left=grid[i][j];
                    if (j>0) left+=dp[i][j-1];
                    else left+=Integer.MAX_VALUE;

                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public int minPathSum3(int[][] grid){
        int n= grid.length;
        int m=grid[0].length;
        int[] prev=new int[n];
        for (int i = 0; i < n; i++) {
            int[] temp=new int[m];
            for (int j = 0; j < m; j++) {
                if (i==0 && j==0) temp[j]=grid[i][j];
                else {
                    int up=grid[i][j];
                    if (i>0) up+=prev[j];
                    else up+=(int)Math.pow(10,9);

                    int left=grid[i][j];
                    if (j>0) left+=temp[j-1];
                    else left+=(int)Math.pow(10,9);
                    temp[j]=Math.min(up,left);
                }
            }
            prev=temp;
        }

        return prev[m-1];
    }
}
