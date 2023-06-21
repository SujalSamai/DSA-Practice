package DP;
//https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
import java.util.Arrays;

public class EvalExpression {
    static int countWays(int N, String S){
        // code here
        int dp[][][]=new int[N+1][N+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(S,0,S.length()-1,true,dp);
    }
    static int func(String str,int i,int j,boolean isTrue,int[][][] dp) {
        if(i>j) return 0;
        if(i==j){
            if(isTrue==true){
                return str.charAt(i)=='T'?1:0;
            }
            else{
                return (str.charAt(i)=='F')?1:0;
            }
        }
        if(dp[i][j][isTrue==true?1:0]!=-1){
            return dp[i][j][isTrue==true?1:0];
        }
        int res=0;
        for(int k=i+1;k<=j-1;k++)
        {
            int lt=func(str,i,k-1,true,dp);
            int lf=func(str,i,k-1,false,dp);
            int rt=func(str,k+1,j,true,dp);
            int rf=func(str,k+1,j,false,dp);
            char ch=str.charAt(k);
            if(ch=='&'){
                if(isTrue==true){
                    res+=lt*rt;
                }
                else{
                    res+=lf*rf+lf*rt+lt*rf;
                }
            }
            else if(ch=='|'){
                if(isTrue==true){
                    res+=lf*rt+lt*rf+lt*rt;
                }
                else{
                    res+=lf*rf;
                }
            }
            else if(ch=='^'){
                if(isTrue==true){
                    res+=lf*rt+lt*rf;
                }
                else{
                    res+=lf*rf+lt*rt;
                }
            }
        }
        return dp[i][j][isTrue==true?1:0]=res%1003;
    }
}
