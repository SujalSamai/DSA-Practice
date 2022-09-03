package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284
public class RodCutting {
    public static int cutRod(int[] price, int n) {
        int[][] dp=new int[n][n+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return cutRodUtil(price,n-1,n,dp);
    }

    private static int cutRodUtil(int[] price, int ind, int n, int[][] dp) {
        if (ind==0) return n*price[0];
        if (dp[ind][n]!=-1) return dp[ind][n];

        int notTaken=cutRodUtil(price,ind-1,n,dp);
        int taken=Integer.MIN_VALUE;
        int rodLength=ind+1;
        if (rodLength<=n){
            taken=price[ind]+cutRodUtil(price,ind,n-rodLength,dp);
        }
        return dp[ind][n]=Math.max(taken,notTaken);
    }
    
    public static int cutRod2(int[] price, int n){
        int[][] dp=new int[n][n+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        for (int i = 0; i <=n ; i++) {
            dp[0][i]=i*price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int len = 0; len <=n ; len++) {
                int notTaken=dp[ind-1][len];
                int taken=Integer.MIN_VALUE;
                int rodLength=ind+1;
                if (rodLength<=len){
                    taken=price[ind]+dp[ind][len-rodLength];
                }
                dp[ind][len]=Math.max(taken,notTaken);
            }
        }
        return dp[n-1][n];
    }
}
