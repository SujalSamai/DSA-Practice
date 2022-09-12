package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintLIS {
    public static int lisPrint(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);

        for (int i = 0; i <=n-1; i++) {
            hash[i]=i;
            for (int prevInd = 0; prevInd <=i-1; prevInd++) {
                if (nums[prevInd]<nums[i] && 1+dp[prevInd]>dp[i]){
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
        System.out.println("The subsequence elements are:");

        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
        return ans;
    }
    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};
        lisPrint(arr);
    }
}
