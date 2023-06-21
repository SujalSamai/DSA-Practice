package DP;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSqSubmatrices {
    public int countSquares(int[][]matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m+2][n+2];
        int res=0;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (matrix[i-1][j-1]==1){
                    int minLen=Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    dp[i][j]=1+minLen;
                    res+=dp[i][j];
                }
            }
        }
        return res;
    }
}
