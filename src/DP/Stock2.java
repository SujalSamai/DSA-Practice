package DP;

import java.util.Arrays;

public class Stock2 {
    //Memoization - Time Complexity: O(N*2), Space Complexity: O(N*2) + O(N)
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int[] row:dp) Arrays.fill(row,-1);
        return getMaxProfit(prices,0,0,n,dp);
    }

    private int getMaxProfit(int[] prices, int ind, int buy, int n, int[][] dp) {
        if (ind==n) return 0;
        if (dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if (buy==0){
            profit=Math.max(getMaxProfit(prices,ind+1,0,n,dp),
                    -prices[ind]+getMaxProfit(prices,ind+1,1,n,dp));
        }
        if (buy==1){
            profit=Math.max(getMaxProfit(prices,ind+1,1,n,dp),
                    prices[ind]+getMaxProfit(prices,ind+1,0,n,dp));
        }
        return dp[ind][buy]=profit;
    }

    //Tabulation -Time Complexity: O(N*2), Space Complexity: O(N*2)
    public int maxProfit2(int[] prices){
        int n= prices.length;
        int[][] dp=new int[n+1][2];
        for (int[] row:dp) Arrays.fill(row,-1);

        dp[n][0]=dp[n][1]=0;
        int profit=0;
        for (int ind = n-1; ind >=0; ind--) {
            for (int buy = 0; buy <=1; buy++) {
                if (buy==0){
                    profit=Math.max(dp[ind+1][0], -prices[ind]+dp[ind+1][1]);
                }
                if (buy==1){
                    profit=Math.max(dp[ind+1][1], prices[ind]+dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][0];
    }

    //Space Optimized
    public int maxProfit3(int[] prices){
        int n= prices.length;
        int[] ahead=new int[2];
        int[] cur=new int[2];
//        ahead[0]=ahead[1]=0;
        int profit=0;
        for (int ind = n-1; ind >=0; ind--) {
            for (int buy = 0; buy <=1; buy++) {
                if (buy==0){
                    profit=Math.max(ahead[0], -prices[ind]+ahead[1]);
                }
                if (buy==1){
                    profit=Math.max(ahead[1], prices[ind]+ahead[0]);
                }
                cur[buy]=profit;
            }
            ahead=cur.clone();
        }
        return cur[0];
    }
}
