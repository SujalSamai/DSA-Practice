package DP;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {

    //memoization TC-O(N) SC-O(N)+O(N)
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums.length-1,nums,dp);
    }

    private int solve(int ind, int[] nums, int[] dp) {
        if (ind<0) return 0;
        if (ind==0) return nums[ind];
        if (dp[ind]!=-1) return dp[ind];

        int pick=nums[ind]+solve(ind-2,nums,dp);
        int notPick=0+solve(ind-1,nums,dp);

        return dp[ind]=Math.max(pick,notPick);
    }

    //tabulation
    public int rob2(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve2(nums.length,nums,dp);
    }

    private int solve2(int n, int[] nums, int[] dp) {
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick=nums[i];
            if (i>1){
                pick+=dp[i-2];
            }
            int nonPick=dp[i-1];

            dp[i]=Math.max(pick,nonPick);
        }
        return dp[n-1];
    }

    //Space Optimised
    public int rob3(int[] nums){
        int prev=nums[0];
        int prev2=0;
        for (int i = 1; i < nums.length ; i++) {
            int pick=nums[i];
            if (i>1){
                pick+=prev2;
            }
            int notPick=prev;

            int curi=Math.max(pick,notPick);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}
