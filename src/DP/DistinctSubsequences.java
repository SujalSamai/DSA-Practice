package DP;
//https://leetcode.com/problems/distinct-subsequences/

import java.util.Arrays;

public class DistinctSubsequences {
    //Memoization - Time Complexity: O(N*M), Space Complexity: O(N*M) + O(N+M)
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return subseqCount(s,t,n-1,m-1,dp);
    }

    private int subseqCount(String s, String t, int ind1, int ind2, int[][] dp) {
        if (ind2<0){
            return 1;
        }
        if (ind1<0){
            return 0;
        }

        if (dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];

        if (s.charAt(ind1)==t.charAt(ind2)){
            int leaveOne=subseqCount(s,t,ind1-1,ind2-1,dp);
            int stay=subseqCount(s,t,ind1-1,ind2,dp);

            return dp[ind1][ind2]=(leaveOne+stay);
        }else{
            return dp[ind1][ind2]=subseqCount(s,t,ind1-1,ind2,dp);
        }
    }

    //Tabulation - Time Complexity: O(N*M), Space Complexity: O(N*M)
    public int numDistinct2(String s, String t){
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m+1; i++) {
            dp[0][i]=0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+ dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    //Space Optimized-
    public int numDistinct3(String s, String t){
        int n=s.length();
        int m=t.length();
        int[] prev=new int[m+1];
        prev[0]=1;
        for (int i = 1; i < n+1; i++) {
            for (int j = m; j >=1 ; j--) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    prev[j]=prev[j-1]+prev[j];
                }
            }
        }
        return prev[m];
    }
}
