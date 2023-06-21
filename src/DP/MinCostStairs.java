package DP;
//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for (int i = 2; i <= n ; i--) {
            int fs=dp[i-1];
            int ss=dp[i-2];
            dp[i]=Math.min(fs,ss) + cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
