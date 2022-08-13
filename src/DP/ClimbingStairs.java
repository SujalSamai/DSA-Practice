package DP;

import java.util.ArrayList;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        int n=2;
        System.out.println(climbStairs(n));
    }
    //Space Optimized TC- O(N) SC- O(1)
    public static int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int prev=2;
        int prev2=1;
        for (int i = 2; i <n ; i++) {
            int curri=prev+prev2;
            prev2=prev;
            prev=curri;
        }
        return prev;
    }

    int memoization(int ind, int[] dp){
        // if(ind == 0) return 1;
        // if(ind == 1) return 1;

        if(ind<=1)
            return 1;

        if(dp[ind] != -1)
            return dp[ind];

        int leftRecursion = memoization(ind-1,dp);
        int rightRecursion = memoization(ind-2,dp);
        int add=leftRecursion+rightRecursion;
        return dp[ind]=add;
    }
    // T.C -> O(n)
    // S.C -> O(n) + O(n)

    // Tabulation:
    int tabulation(int n){
        int[] dp=new int[n+1];

        dp[0]=1;
        dp[1]=2;

        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    // T.C -> O(n)
    // S.C -> O(n)
}
