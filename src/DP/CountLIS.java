package DP;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence
import java.util.Arrays;

public class CountLIS {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        int maxi=1;
        for (int i = 0; i < n; i++) {
            for (int prevInd = 0; prevInd < i; prevInd++) {
                if (nums[prevInd]<nums[i] && dp[prevInd]+1 > dp[i]){
                    dp[i]=dp[prevInd]+1;
                    cnt[i]=cnt[prevInd];
                }else if (nums[prevInd]<nums[i] && dp[prevInd]+1==dp[i]){
                    cnt[i]=cnt[i]+cnt[prevInd];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        int nos=0;
        for (int i = 0; i < n; i++) {
            if (dp[i]==maxi) nos+=cnt[i];
        }
        return nos;
    }
}
