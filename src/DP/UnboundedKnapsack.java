package DP;
//https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029

import java.util.Arrays;

public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return knapsackUtil(weight,profit,n-1, w,dp);
    }

    private static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if (ind==0){
            return ((int)(W/wt[0])) * val[0];
        }
        if (dp[ind][W]!=-1) return dp[ind][W];
        int notTaken= knapsackUtil(wt,val,ind-1,W,dp);
        int taken=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            taken=val[ind]+knapsackUtil(wt,val,ind,W-wt[ind],dp);
        }
        return dp[ind][W]=Math.max(taken,notTaken);
    }

    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight){
        int[][] dp=new int[n][w+1];
        for (int i = weight[0]; i <=w; i++) {
            dp[0][i]=((int)(i/weight[0]))*profit[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <=w; cap++) {
                int notTaken=dp[ind-1][cap];
                int taken =Integer.MIN_VALUE;
                if (weight[ind]<=cap){
                    taken=profit[ind]+dp[ind][cap-weight[ind]];
                }
                dp[ind][cap]=Math.max(taken,notTaken);
            }
        }
        return dp[n-1][w];
    }

}
