package DP;
//https://leetcode.com/problems/regular-expression-matching/

import java.util.Arrays;

public class ExpressionMatching {

    public static boolean isMatch(String s, String p){
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        return isMatchUtil(dp,s,p,0,0);
    }

    private static boolean isMatchUtil(boolean[][] dp, String s, String p, int i, int j) {
        if (dp[i][j]!=false) return dp[i][j];
        if (i>=s.length() && j>=p.length()) return true;
        if (j>=p.length()) return false;

        boolean match= i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        if (j+1<p.length() && p.charAt(j+1)=='*'){
            dp[i][j]=isMatchUtil(dp,s,p,i,j+2) || (match && isMatchUtil(dp,s,p,i+1,j));
        }else{
            dp[i][j]= match && isMatchUtil(dp,s,p,i+1,j+1);
        }
        return dp[i][j];
    }

    public static void main(String args[]) {

        String S1 = "aab";
        String S2 = "c*a*b";

        System.out.println(isMatch(S1,S2));
    }
}
