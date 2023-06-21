package DP;
//https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
import java.util.Arrays;

public class LongestBitonicSubseq {
    public int LongestBitonicSequence(int[] nums) {
        int n=nums.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);

        for (int i = 0; i <=n-1; i++) {
            for (int prevInd = 0; prevInd <=i-1; prevInd++) {
                if (nums[prevInd]<nums[i]){
                    dp1[i]=Math.max(dp1[i],1+dp1[prevInd]);
                }
            }
        }
        //reverse
        for (int i = n-1; i >=0; i--) {
            for (int prevInd = n-1; prevInd >i ; prevInd--) {
                if (nums[prevInd]<nums[i]){
                    dp2[i]=Math.max(dp2[i],1+dp2[prevInd]);
                }
            }
        }
        int maxi=-1;
        for (int i = 0; i < n; i++) {
            maxi=Math.max(maxi, dp1[i]+dp2[i]-1);
        }
        return maxi;
    }
}
