package DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
import java.util.Arrays;

public class StockFee {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int[] row:dp) Arrays.fill(row,-1);
        return getMaxProfit(prices,0,1,fee,dp);
    }

    private int getMaxProfit(int[] prices, int ind, int buy, int fee,int[][] dp) {
        if (ind>=prices.length) return 0;
        if (dp[ind][buy]!=-1) return dp[ind][buy];
        if (buy==1){
            return dp[ind][buy]=Math.max(getMaxProfit(prices,ind+1,1,fee,dp),
                    -prices[ind]+getMaxProfit(prices,ind+1,0,fee,dp));
        }
        return dp[ind][buy]=Math.max(getMaxProfit(prices,ind+1,0,fee,dp),
                prices[ind]-fee+getMaxProfit(prices,ind+1,1,fee,dp));

    }

    public int maxProfit2(int[] prices, int fee){
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        for (int ind=n-1; ind>=0; ind--){
            dp[ind][1]=Math.max(-prices[ind]+ dp[ind+1][0], dp[ind+1][1]);
            dp[ind][0]=Math.max((prices[ind]-fee)+dp[ind+1][1], dp[ind+1][0]);
        }
        return dp[0][1];
    }
}
