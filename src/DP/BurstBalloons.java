package DP;

import java.util.Arrays;

//https://leetcode.com/problems/burst-balloons/
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int[][] dp=new int[n+1][n+1];
        for (int[] row:dp) Arrays.fill(row,-1);
        int[] arr=new int[n+2];
        for (int i = 1; i <=n; i++) {
            arr[i]=nums[i-1];
        }
        arr[0]=1;
        arr[n+1]=1;
        return coins(arr,1,n,dp);
    }

    private int coins(int[] arr, int i, int j, int[][] dp) {
        if (i>j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        for (int k = i; k <=j; k++) {
            int coin=arr[i-1]*arr[j+1]*arr[k] + coins(arr,i,k-1,dp)+ coins(arr,k+1,j,dp);
            dp[i][j]=(int)Math.max(dp[i][j], coin);
        }
        return dp[i][j];
    }

    public int maxCoins2(int[] nums){
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        for (int i=1; i<=n; i++){
            arr[i]=nums[i-1];
        }
        arr[0]=1;
        arr[n+1]=1;
        for (int i=n; i>=1; i--){
            for (int j=i; j<=n; j++){
                for (int k=i; k<=j; k++){
                    int coin=arr[i-1]*arr[j+1]*arr[k] + dp[i][k-1]+ dp[k+1][j];
                    dp[i][j]=(int)Math.max(dp[i][j], coin);
                }
            }
        }
        return dp[1][n];
    }
}
