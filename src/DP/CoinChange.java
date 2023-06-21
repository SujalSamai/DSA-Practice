package DP;
//https://leetcode.com/problems/coin-change
import java.util.Arrays;

public class CoinChange {
    //Memoization -Time Complexity: O(N*T), Space Complexity: O(N*T) + O(N)
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        int ans=minCoins(coins, n-1, amount,dp);
        if (ans>=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    private int minCoins(int[] coins, int ind, int amount, int[][] dp) {
        if (ind==0) {
            if (amount%coins[0]==0) return amount/coins[0];
            else return (int)Math.pow(10,9);
        }
        if (dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int notTaken=minCoins(coins,ind-1,amount,dp);
        int taken=(int)Math.pow(10,9);
        if (coins[ind]<=amount){
            taken=1+minCoins(coins,ind,amount-coins[ind],dp);
        }
        return dp[ind][amount]=Math.min(notTaken,taken);
    }

    //Tabulation -Time Complexity: O(N*T), Space Complexity: O(N*T)
    public int coinChange2(int[] coins, int amount){
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int i = 0; i <=amount; i++) {
            if (i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=(int)Math.pow(10,9);
            }
        }
        for (int ind = 1; ind <n ; ind++) {
            for (int target = 0; target <=amount ; target++) {
                int notTake=dp[ind-1][target];
                int take=(int)Math.pow(10,9);
                if (coins[ind]<=target){
                    take=1+dp[ind][target-coins[ind]];
                }
                dp[ind][target]=Math.min(notTake,take);
            }
        }
        int ans=dp[n-1][amount];
        if (ans>=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    //Space Optimized
    public int coinChange3(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
