package DP;
//https://leetcode.com/problems/largest-divisible-subset/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);
        for (int i = 0; i <=n-1; i++) {
            hash[i]=i;
            for (int prevInd = 0; prevInd <=i-1; prevInd++) {
                if (nums[i]%nums[prevInd]==0 && 1+dp[prevInd]>dp[i]){
                    dp[i]=1+dp[prevInd];
                    hash[i]=prevInd;
                }
            }
        }
        int ans=-1;
        int lastInd=-1;
        for (int i = 0; i <=n-1; i++) {
            if (dp[i]>ans){
                ans=dp[i];
                lastInd=i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[lastInd]);
        while (hash[lastInd]!=lastInd){
            lastInd=hash[lastInd];
            temp.add(nums[lastInd]);
        }

        Collections.reverse(temp);
        return temp;
    }
}
