package DP;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class Stock3 {
    //Memoization - Time Complexity: O(N*2*3), Space Complexity: O(N*2*3) + O(N)
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for (int[][] row:dp){
            for (int[] rowCol:row){
                Arrays.fill(rowCol,-1);
            }
        }
        return getProfit(prices,n,0,0,2,dp);
    }

    private int getProfit(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        if (ind==n || cap==0) return 0;
        if (dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        int profit=0;
        if (buy==0){
            profit=Math.max(getProfit(prices,n, ind+1,0, cap, dp), -prices[ind]+getProfit(prices,n, ind+1,1,cap,dp));
        }
        if (buy==1){
            profit=Math.max(getProfit(prices,n,ind+1,1,cap,dp),
                    prices[ind] + getProfit(prices,n,ind+1,0,cap-1,dp));
        }
        return dp[ind][buy][cap]=profit;
    }

    //Tabulation -Time Complexity: O(N*2*3), Space Complexity: O(N*2*3)
    public int maxProfit2(int[] prices){
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for (int[][] row:dp){
            for (int[] rowCol:row){
                Arrays.fill(rowCol,0);
            }
        }

        for (int ind = n-1; ind >=0; ind--) {
            for (int buy = 0; buy <=1; buy++) {
                for (int cap = 1; cap <=2; cap++) {
                    if (buy==0){
                        dp[ind][buy][cap]=Math.max(dp[ind+1][0][cap], -prices[ind]+dp[ind+1][1][cap]);
                    }
                    if (buy==1){
                        dp[ind][buy][cap]=Math.max(dp[ind+1][1][cap],
                                prices[ind] + dp[ind+1][0][cap-1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }

    //Space optimized -
    public int maxProfit3(int[] prices){
        int[][] ahead=new int[2][3];
        int[][] cur=new int[2][3];

        for (int ind = prices.length-1; ind >=0; ind--) {
            for (int buy = 0; buy <=1; buy++) {
                for (int cap = 1; cap <=2 ; cap++) {
                    if (buy==0){
                        cur[buy][cap]=Math.max(ahead[0][cap], -prices[ind]+ahead[1][cap]);
                    }
                    if (buy==1){
                        cur[buy][cap]=Math.max(ahead[1][cap], prices[ind] + ahead[0][cap-1]);
                    }
                }
            }
            ahead=cur;
        }
        return ahead[0][2];
    }
}
