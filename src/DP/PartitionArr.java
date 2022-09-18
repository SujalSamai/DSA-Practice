package DP;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/partition-array-for-maximum-sum/
public class PartitionArr {
    //Memoization
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return partition(arr,0,k,dp);
    }

    private int partition(int[] arr, int ind, int k, int[] dp) {
        if (ind==arr.length) return 0;
        if (dp[ind]!=-1) return dp[ind];

        int maxAns=Integer.MIN_VALUE;
        int maxEl=Integer.MIN_VALUE;
        int len=0;
        for (int i = ind; i < Math.min(arr.length,ind+k); i++) {
            len++;
            maxEl=Math.max(maxEl,arr[i]);
            maxAns=Math.max(maxAns, len*maxEl + partition(arr,i+1,k,dp));
        }
        return dp[ind]=maxAns;
    }

    //Tabulation
    public int maxSumAfterPartitioning2(int[] arr, int k){
        int n=arr.length;
        int[] dp=new int[n+1];
        for (int ind = n-1; ind >=0 ; ind--) {
            int maxAns=Integer.MIN_VALUE;
            int maxEl=Integer.MIN_VALUE;
            int len=0;
            for (int i = ind; i <Math.min(arr.length,ind+k); i++) {
                len++;
                maxEl=Math.max(maxAns,arr[i]);
                maxAns=Math.max(maxAns, len*maxEl + dp[i+1]);
            }
            dp[ind]=maxAns;
        }
        return dp[0];
    }
}
