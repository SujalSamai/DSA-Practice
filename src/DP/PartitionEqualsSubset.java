package DP;

import java.util.Arrays;

public class PartitionEqualsSubset {
    //Memoization - Time Complexity: O(N*K) + O(N), Space Complexity: O(N*K) + O(N)
    public boolean canPartition(int[] nums) {
        int totSum=0;
        for (int i = 0; i < nums.length; i++) {
            totSum+=nums[i];
        }
        if(totSum%2==1) return false;
        else{
            int k=totSum/2;
            int[][] dp=new int[nums.length][k+1];
            for (int[] row:dp) {
                Arrays.fill(row,-1);
            }
            return subsetSumUtil(nums.length-1,k,nums,dp);
        }
    }

    private boolean subsetSumUtil(int ind, int target, int[] nums, int[][] dp) {
        if (target==0) return true;
        if (ind==0) return nums[0]==target;
        if (dp[ind][target]!=-1) return dp[ind][target]==0?false:true;

        boolean notTaken=subsetSumUtil(ind-1,target,nums,dp);
        boolean taken=false;
        if (nums[ind]<=target){
            taken=subsetSumUtil(ind-1,target-nums[ind],nums,dp);
            dp[ind][target]=notTaken||taken?1:0;
        }
        return taken||notTaken;
    }

    //Tabulation - Time Complexity: O(N*K) +O(N), Space Complexity: O(N*K)
    public boolean canPartition2(int[] nums){
        int n= nums.length;
        int totSum=0;
        for (int i = 0; i < n; i++) {
            totSum+=nums[i];
        }
        if (totSum%2==1) return false;
        else{
            int k=totSum/2;
            boolean[][] dp=new boolean[n][k+1];
            for (int i = 0; i < n; i++) {
                dp[i][0]=true;
            }
            if (nums[0]<=k){
                dp[0][nums[0]]=true;
            }
            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <=k; target++) {
                    boolean notTaken=dp[ind-1][target];
                    boolean taken=false;
                    if (nums[ind]<=target){
                        taken=dp[ind-1][target-nums[ind]];
                    }
                    dp[ind][target]=notTaken||taken;
                }
            }
            return dp[n-1][k];
        }
    }

    //Space optimised
    public boolean canPartition3(int[] nums){
        int n= nums.length;
        int totSum=0;
        for (int i = 0; i < n; i++) {
            totSum+=nums[i];
        }
        if (totSum%2==1) return false;
        else{
            int k=totSum/2;
            boolean[]prev= new boolean[k+1];
            prev[0]=true;
            if (nums[0]<=k){
                prev[nums[0]]=true;
            }
            for (int ind = 1; ind < n; ind++) {
                boolean[] cur=new boolean[k+1];
                cur[0]=true;
                for (int target = 1; target <=k; target++) {
                    boolean notTaken=prev[target];
                    boolean taken=false;
                    if (nums[ind]<=target){
                        taken=prev[target-nums[ind]];
                    }
                    cur[target]=notTaken||taken;
                }
                prev=cur;
            }
            return prev[k];
        }
    }
}
