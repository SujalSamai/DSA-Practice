package DP;

import java.util.Arrays;

public class NinjasTraining {
    //memoisation -Time Complexity: O(N*4*3)
    //Space Complexity: O(N) + O(N*4)
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp=new int[n][4];
        Arrays.fill(dp,-1);
        return func(n-1,3,points,dp);
    }

    private static int func(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last]!=-1) return dp[day][last];

        if (day==0){
            int maxi=0;
            for (int i = 0; i <=2; i++) {
                if (i!=last){
                    maxi=Math.max(maxi,points[0][i]);
                }
            }
            return dp[day][last]=maxi;
        }

        int maxi=0;
        for (int i = 0; i <=2; i++) {
            if (i!=last){
                int activity=points[day][i] + func(day-1,i,points,dp);
                maxi=Math.max(maxi,activity);
            }
        }
        return dp[day][last]=maxi;
    }

    //tabulation -Time Complexity: O(N*4*3)
    //Space Complexity: O(N*4)
    public static int ninjaTraining2(int n, int[][] points){
        int[][] dp=new int[n][4];
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][2],points[0][0]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last <4 ; last++) {
                dp[day][last]=0;
                for (int task = 0; task <=2; task++) {
                    if (task!=last){
                        int activity=points[day][task] + dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],activity);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    //space optimization
    public static int ninjaTraining3(int n, int[][] points){
        int[] prev=new int[4];

        prev[0]=Math.max(points[0][1],points[0][2]);
        prev[1]=Math.max(points[0][0],points[0][2]);
        prev[2]=Math.max(points[0][1],points[0][0]);
        prev[3]=Math.max(points[0][1],Math.max(points[0][2],points[0][0]));

        for (int day = 1; day < n; day++) {
            int[] temp=new int[4];
            for (int last = 0; last <4 ; last++) {
                temp[last]=0;
                for (int task = 0; task <=2; task++) {
                    if (task!=last){
                        temp[last]=Math.max(temp[last],points[day][task]+prev[task]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }
}
