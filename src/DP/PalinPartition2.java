package DP;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalinPartition2 {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return minCutUtil(s,0,n,dp)-1;
    }

    private int minCutUtil(String s, int i, int n, int[] dp) {
        if (i==n) return 0;
        if (dp[i]!=-1) return dp[i];
        int mini=Integer.MAX_VALUE;
        for (int ind = i; ind < n; ind++) {
            if (isPalin(i,ind,s)){
                mini=Math.min(mini, 1+minCutUtil(s,ind+1,n,dp));
            }
        }
        return dp[i]=mini;
    }

    private boolean isPalin(int i, int j, String s) {
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //Tabulation
    public int minCut2(String s){
        int n=s.length();
        int[] dp=new int[n+1];
        for (int i = n-1; i >=0; i--) {
            int mini=Integer.MAX_VALUE;
            for (int ind = i; ind < n; ind++) {
                if (isPalin(i,ind,s)){
                    mini=Math.min(mini, 1+dp[ind+1]);
                }
            }
            dp[i]=mini;
        }
        return dp[0]-1;
    }
}
