package DP;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

public class CountSubsets {
    //Memoisation - Time Complexity: O(N*K), Space Complexity: O(N*K) + O(N)
    public static int findWays(int num[], int tar) {
        int n= num.length;
        int[][] dp=new int[n][tar+1];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return findWaysUtil(n-1,tar,num,dp);
    }

    private static int findWaysUtil(int ind, int tar, int[] num, int[][] dp) {
        if (tar==0) return 1;
        if (ind==0) return num[0]==tar?1:0;
        if (dp[ind][tar]!=-1) return dp[ind][tar];
        int notTaken=findWaysUtil(ind-1,tar,num,dp);
        int taken=0;
        if (num[ind]<=tar){
            taken=findWaysUtil(ind-1, tar-num[ind],num,dp);
        }
        return dp[ind][tar]=notTaken+taken;
    }

    public static int findWays2(int[] num, int tar){
        int n=num.length;
        int[][] dp=new int[n][tar+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
        }
        if (num[0]<=tar){
            dp[0][num[0]]=1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <=tar; target++) {
                int nottaken=dp[ind-1][target];
                int taken=0;
                if (num[ind]<=target){
                    taken=dp[ind-1][target-num[ind]];
                }
                dp[ind][target]=nottaken+taken;
            }
        }
        return dp[n-1][tar];
    }
}
