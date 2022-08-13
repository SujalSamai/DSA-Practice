package DP;

import java.util.Arrays;

public class FrogJumpKDist {
    public static void main(String args[]) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k=2;
        System.out.println(kJump(n,height,k));
    }
    public static int kJump(int n, int[] height, int k){
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(n,height,dp,k);
    }

    private static int fun(int n, int[] height, int[] dp, int k) {
        dp[0]=0;
        for (int i = 1; i < n; i++) {
            int mmSteps=Integer.MAX_VALUE;
            for (int j = 1; j <=k ; j++) {
                if (i-j>=0){
                    int jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    mmSteps=Math.min(jump,mmSteps);
                }
            }
            dp[i]=mmSteps;
        }
        return dp[n-1];
    }
}
