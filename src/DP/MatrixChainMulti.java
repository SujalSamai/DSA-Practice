package DP;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class MatrixChainMulti {
    static int matrixMultiplication(int N, int[] arr) {
        // code here
        int[][] dp=new int[N][N];
        for (int[] row:dp) Arrays.fill(row,-1);
        int i=1;
        int j=N-1;

        return mcmUtil(arr,i,j,dp);
    }

    private static int mcmUtil(int[] arr, int i, int j, int[][] dp) {
        if (i==j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;

        for (int k = i; k <=j-1; k++) {
            int ans=mcmUtil(arr,i,k,dp)+mcmUtil(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            mini=Math.min(mini,ans);
        }
        return mini;
    }

    static int matrixMultiplication2(int N, int[] arr){
        int[][] dp=new int[N][N];
        for (int i = 1; i < N; i++) {
            dp[i][i]=0;
        }
        for (int i = N-1; i >=1; i--) {
            for (int j = i+1; j < N; j++) {
                int mini=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    if (steps<mini){
                        mini=steps;
                    }
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][N-1];
    }

}
