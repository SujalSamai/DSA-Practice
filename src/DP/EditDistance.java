package DP;
//https://leetcode.com/problems/edit-distance/
import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp=new int[n][m];
        for(int row[]: dp) {
            Arrays.fill(row,-1);
        }
        return editDistanceUtil(word1,word2,n-1,m-1,dp);
    }

    private int editDistanceUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1<0) return ind2+1;
        if (ind2<0) return ind1+1;
        if (dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if (s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2]=editDistanceUtil(s1,s2,ind1-1,ind2-1,dp);
        }

        else return dp[ind1][ind2]=1+Math.min(editDistanceUtil(s1,s2,ind1-1,ind2-1,dp),
                Math.min(editDistanceUtil(s1,s2,ind1-1,ind2,dp),editDistanceUtil(s1,s2,ind1,ind2-1,dp)));
    }

    public int minDistance2(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }

                else dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
}
