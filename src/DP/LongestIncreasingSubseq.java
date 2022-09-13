package DP;
//https://leetcode.com/problems/longest-increasing-subsequence
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubseq {
    //Memoization - Time Complexity: O(N*N), Space Complexity: O(N*N) + O(N)
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for (int[] row:dp) Arrays.fill(row,-1);
        return getLength(nums,n,0,-1,dp);
    }

    private int getLength(int[] nums, int n, int ind, int prevInd, int[][] dp) {
        if (ind==n){
            return 0;
        }
        if (dp[ind][prevInd+1]!=-1) return dp[ind][prevInd+1];

        int notTake=getLength(nums,n, ind+1, prevInd,dp);
        int take=0;
        if (prevInd==-1 || nums[ind]>nums[prevInd]){
            take=1+ getLength(nums,n,ind+1,ind,dp);
        }

        return dp[ind][prevInd+1]=Math.max(notTake,take);
    }

    //Tabulation -Time Complexity: O(N*N). Space Complexity: O(N*N)
    public int lengthOfLIS2(int[] nums){
        int n= nums.length;
        int[][] dp=new int[n+1][n+1];
        for (int ind = n-1; ind >=0 ; ind--) {
            for (int prevInd = ind-1; prevInd >=-1 ; prevInd--) {
                int notTake=dp[ind+1][prevInd+1];
                int take=0;
                if (prevInd==-1 || nums[ind]>nums[prevInd]){
                    take=1+ dp[ind+1][ind+1];
                }
                dp[ind][prevInd+1]=Math.max(notTake,take);
            }
        }
        return dp[0][0];
    }

    //Tabulation - Approach 2
    //We know that a single element can always be considered to be included in the LIS, as it can not break any rule of forming the LIS.
    // Therefore we can initialize the dp array by 1, it simply means that currently, LIS is having only that particular member element
    // itself ([5], [4], [11], …).
    public int lengthOfLIS21(int[] nums){
        int n= nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i <=n-1; i++) {
            for (int prevInd = 0; prevInd <=i-1; prevInd++) {
                if (nums[prevInd]<nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[prevInd]);
                }
            }
        }
        int ans=-1;
        for (int i = 0; i <=n-1; i++) {
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    //Space Optimized - Time Complexity: O(N*N), Space Complexity: O(N)
    public int lengthOfLIS3(int[] nums){
        int n= nums.length;
        int next[]=new int[n+1];
        int cur[]=new int[n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                int notTake = next[prev_index +1];
                int take = 0;
                if(prev_index == -1 || nums[ind] > nums[prev_index]){
                    take = 1 + next[ind+1];
                }
                cur[prev_index+1] = Math.max(notTake,take);
            }
            next = cur.clone();
        }
        return cur[0];
    }

    //Binary Search
    public int lengthOfLISBS(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        temp[0]=nums[0];
        for (int i=1;i<nums.length;i++) {
            if(nums[i]>temp[size]){
                // arr[i] > the last element of temp array
                temp[++size]=nums[i];
            }
            else{
                // replacement step
                int ind = lower_bound(temp,0,size,nums[i]);
                temp[ind] = nums[i];
            }
        }
        return size+1;
    }
    public int lower_bound(int[] nums, int i, int j,int x){
        while (i < j) {
            int m = i + (j-i) / 2;
            if (nums[m] < x)
                i = m + 1;
            else
                j = m;
        }

        return i;
    }
}
