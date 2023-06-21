package DP;

import java.util.Arrays;

public class Stock4 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp=new int[prices.length][2*k];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return profitUtil(0,0,prices, prices.length, k, dp);
    }

    private int profitUtil(int ind, int transNo, int[] prices, int n, int k, int[][] dp) {
        if (ind==n || transNo== 2*k) return 0;
        if (dp[ind][transNo]!=-1) return dp[ind][transNo];
        if (transNo%2==0) {
            return dp[ind][transNo]=Math.max(-prices[ind]+profitUtil(ind+1, transNo+1, prices, n, k, dp),
                    profitUtil(ind+1,transNo,prices,n,k, dp));
        }
        return dp[ind][transNo]=Math.max(prices[ind]+profitUtil(ind+1, transNo+1, prices, n, k, dp),
                profitUtil(ind+1, transNo, prices,n,k, dp));
    }

    public int maxProfit2(int k, int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+1][2*k+1];
        for (int ind=n-1; ind>=0; ind--){
            for (int transNo=2*k-1; transNo>=0; transNo--){
                if (transNo%2==0) {
                    dp[ind][transNo]=Math.max(-prices[ind]+dp[ind+1][transNo+1], dp[ind+1][transNo]);
                }
                else dp[ind][transNo]=Math.max(prices[ind]+dp[ind+1][transNo+1], dp[ind+1][transNo]);
            }
        }
        return dp[0][0];
    }

    public int maxProfit3(int k, int[] prices){
        int n=prices.length;
        int[]after=new int[2*k+1];
        int[] cur=new int[2*k+1];
        for (int ind=n-1; ind>=0; ind--){
            for (int transNo=2*k-1; transNo>=0; transNo--){
                if (transNo%2==0) {
                    cur[transNo]=Math.max(-prices[ind]+after[transNo+1], after[transNo]);
                }
                else cur[transNo]=Math.max(prices[ind]+after[transNo+1], after[transNo]);
            }
            after=cur;
        }
        return after[0];
    }
}
