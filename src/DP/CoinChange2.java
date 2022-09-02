package DP;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-2/
public class CoinChange2 {
    //Memoization
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return countChange(coins,coins.length-1,amount,dp);
    }

    private int countChange(int[] coins, int ind, int amount, int[][] dp) {
        if (ind==0){
            if (amount%coins[0]==0) return 1;
            else return 0;
        }
        if (dp[ind][amount]!=-1) return dp[ind][amount];

        int notTaken=countChange(coins,ind-1,amount,dp);
        int taken=0;
        if (coins[ind]<=amount){
            taken=countChange(coins,ind, amount-coins[ind],dp);
        }
        return dp[ind][amount]=notTaken+taken;
    }

    //Tabulation
    public int change2(int amount, int[] coins){
        int[][] dp=new int[coins.length][amount+1];
        for (int i = 0; i <= amount; i++) {
            if (i%coins[0]==0){
                dp[0][i]=1;
            }
        }

        for (int ind = 1; ind < coins.length; ind++) {
            for (int target = 0; target < amount; target++) {
                int notTaken=dp[ind-1][target];
                int taken=0;
                if (coins[ind]<=target){
                    taken=dp[ind][target-coins[ind]];
                }
                dp[ind][target]=notTaken+taken;
            }
        }
        return dp[coins.length-1][amount];
    }

    //space optimized
    public int change3(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);

        // if amount is 0, there is only 1 way of making change (no money)
        dp[0] = 1;

        for (int coin: coins){
            for (int i = 1; i <= amount; i++){
                if (coin <= i){
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[amount];

    }
}
