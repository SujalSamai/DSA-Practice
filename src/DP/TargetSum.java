package DP;

import java.util.Arrays;

//https://leetcode.com/problems/target-sum/
public class TargetSum {
    //Memoization
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for (int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
        }
        if (totalSum-target<0 || (totalSum-target)%2==1) return 0;
        int s2=(totalSum-target)/2;
        int[][] dp=new int[nums.length][s2+1];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return countPartitions(nums.length-1,s2,nums,dp);
    }

    private int countPartitions(int ind, int target, int[] nums, int[][] dp) {
        if (ind==0){
            if (target==0 && nums[0]==0){
                return 2;
            }
            if (target==0 || target==nums[0]){
                return 1;
            }
            return 0;
        }

        if (dp[ind][target]!=-1) return dp[ind][target];
        int notTaken=countPartitions(ind-1, target, nums, dp);
        int taken=0;
        if (nums[ind]<=target) taken=countPartitions(ind-1, target-nums[ind], nums, dp);
        return dp[ind][target]=notTaken+taken;
    }

    //Tabulation
    public int findTargetSumWays2(int[] nums, int target){
        int totSum=0;
        for (int i = 0; i < nums.length; i++) {
            totSum+=nums[i];
        }
        if (totSum-target<0 || (totSum-target)%2==1) return 0;
        return findWays(nums,(totSum-target)/2);
    }

    private int findWays(int[] nums, int target) {
        int[][] dp=new int[nums.length][target+1];
        if (nums[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if (nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;
        for(int ind = 1; ind< nums.length; ind++){
            for(int tar= 0; tar<=target; tar++){

                int notTaken = dp[ind-1][tar];

                int taken = 0;
                if(nums[ind]<=tar)
                    taken = dp[ind-1][tar-nums[ind]];

                dp[ind][tar]= (notTaken + taken)%((int)(Math.pow(10,9)+7));
            }
        }
        return dp[nums.length-1][target];
    }
}
