package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n-1,heights,dp);
    }

    //memoization
    private static int fun(int ind, int[] heights, int[] dp) {
        if (ind==0) return 0;
        if (dp[ind]!=-1) return dp[ind];
        int left=fun(ind-1, heights,dp)+ Math.abs(heights[ind]-heights[ind-1]);
        int right= Integer.MAX_VALUE;
        if (ind>1){
            right=fun(ind-2,heights,dp)+ Math.abs(heights[ind]-heights[ind-2]);
        }
        return dp[ind]=Math.min(left,right);
    }

    //tabulation
    private static int frogJump2(int n, int[] heights){
        int[] dp= new int[n];
        Arrays.fill(dp,0);
        for (int i = 1; i <n ; i++) {
            int fs=dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int ss=Integer.MAX_VALUE;
            if (i>1){
                ss=dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i]=Math.min(fs,ss);
        }
        return dp[n-1];
    }

    //Space Optimization
    private static int fromJump3(int n, int[] heights){
        int prev=0;
        int prev2=0;
        for (int i = 1; i < n; i++) {
            int fs=prev+ Math.abs(heights[i]-heights[i-1]);
            int ss=Integer.MAX_VALUE;
            if (i>1){
                ss=prev2+ Math.abs(heights[i]-heights[i-2]);
            }
            int curi=Math.min(ss,fs);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}
