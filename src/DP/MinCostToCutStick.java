package DP;
//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
import java.util.Arrays;

public class MinCostToCutStick {
    public int minCost(int n, int[] cuts) {
        int l= cuts.length;
        Arrays.sort(cuts);
        int[] arr=new int[l+2];
        for (int i = 1; i <= l; i++) {
            arr[i]=cuts[i-1];
        }
        arr[0]=0;
        arr[l+1]=n;
        int[][] dp=new int[l+1][l+1];
        for (int[] row:dp) Arrays.fill(row,-1);
        return cutStick(arr,1,l,dp);
    }

    private int cutStick(int[] arr, int i, int j, int[][] dp) {
        if (i>j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for (int k = i; k <=j; k++) {
            int cost= arr[j+1] - arr[i-1] + cutStick(arr,i,k-1,dp) + cutStick(arr,k+1,j,dp);
            mini=Math.min(cost,mini);
        }
        return dp[i][j]=mini;
    }

    public int minCost2(int n, int[] cuts){
        int len=cuts.length;
        Arrays.sort(cuts);
        int[] arr=new int[len+2];
        for (int i = 1; i <= len; i++) {
            arr[i]=cuts[i-1];
        }
        arr[0]=0;
        arr[len+1]=n;
        int[][] dp=new int[len+2][len+2];

        for (int i = len; i >=1; i--) {
            for (int j = 1; j <=len; j++) {
                if (i>j) continue;
                int mini=Integer.MAX_VALUE;
                for (int k = i; k <=j; k++) {
                    int cost=arr[j+1] - arr[i-1] + dp[i][k-1] + dp[k+1][j];
                    mini=Math.min(cost, mini);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][len];
    }
}
