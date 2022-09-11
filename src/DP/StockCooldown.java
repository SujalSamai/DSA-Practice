package DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

import java.util.Arrays;

public class StockCooldown {
    //Memoization
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int[] row:dp) Arrays.fill(row,-1);
        return getMaxProfit(prices,0,1,dp);
    }

    private int getMaxProfit(int[] prices, int ind, int buy, int[][] dp) {
        if (ind>=prices.length) return 0;
        if (dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if (buy==1){
            return dp[ind][buy]=Math.max(getMaxProfit(prices,ind+1,1,dp),
                    -prices[ind]+getMaxProfit(prices,ind+1,0,dp));
        }
        return dp[ind][buy]=Math.max(getMaxProfit(prices,ind+1,0,dp),
                    prices[ind]+getMaxProfit(prices,ind+2,1,dp));

    }

    //Tabulation
    public int maxProfit2(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        for (int ind=n-1; ind>=0; ind--){
            dp[ind][1]=Math.max(-prices[ind]+ dp[ind+1][0], dp[ind+1][1]);
            dp[ind][0]=Math.max(prices[ind]+dp[ind+2][1], dp[ind+1][0]);
        }
        return dp[0][1];
    }
}
