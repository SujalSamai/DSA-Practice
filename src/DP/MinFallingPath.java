package DP;

import java.util.Arrays;

public class MinFallingPath {
    //Memoization Time Complexity: O(N*N), Space Complexity: O(N) + O(N*M)
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row,-1);
        }
        int mini=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int ans=getMin(0,i,m,matrix,dp);
            mini=Math.min(mini,ans);
        }
        return mini;
    }

    private int getMin(int i, int j, int m, int[][] matrix, int[][] dp) {
        if (j<0 || j> matrix[0].length-1){
            return (int)Math.pow(10,9);
        }
        if (i== matrix.length-1){
            return matrix[i][j];
        }
        if (dp[i][j]!=-1) return dp[i][j];
        int up=matrix[i][j] + getMin(i+1,j,m,matrix,dp);
        int leftDiag=matrix[i][j] + getMin(i+1,j-1,m,matrix,dp);
        int rightDiag= matrix[i][j]+ getMin(i+1,j+1,m ,matrix,dp);

        return dp[i][j]=Math.min(up, Math.min(leftDiag,rightDiag));
    }


    //Tabulation - Time Complexity: O(N*M), Space Complexity: O(N*M)
    public int minFallingPathSum2(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[n-1][i]=matrix[n-1][i];
        }

        for (int i = n-2; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                int down= matrix[i][j]+dp[i+1][j];
                int ld=matrix[i][j];
                int rd=matrix[i][j];
                if(j>0)
                    ld+=dp[i+1][j-1];
                else
                    ld+=((int)Math.pow(10,9));
                if(j<matrix[0].length-1)
                    rd+=dp[i+1][j+1];
                else
                    rd+=((int)Math.pow(10,9));

                dp[i][j]=Math.min(down,Math.min(ld,rd));
            }
        }
        int min=(int)Math.pow(10,9);
        for (int i = 0; i < dp[0].length; i++) {
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }

    //Space Optimization- Time Complexity: O(N*M)
    //Space Complexity: O(M)
    public int minFallingPathSum3(int[][] matrix){
        int n= matrix.length;
        int m=matrix[0].length;
        int[] next=new int[m];
        for (int i = 0; i < m; i++) {
            next[i]=matrix[n-1][i];
        }
        for (int i = n-2; i >=0 ; i--) {
            int[] curr=new int[m];
            for (int j = m-1; j >=0 ; j--) {
                int down=matrix[i][j]+next[j];
                int ld=matrix[i][j];
                int rd=matrix[i][j];
                if(j>0)
                    ld+=next[j-1];
                else
                    ld+=((int)Math.pow(10,9));
                if(j<matrix[0].length-1)
                    rd+=next[j+1];
                else
                    rd+=((int)Math.pow(10,9));

                curr[j]=Math.min(down, Math.min(ld,rd));
            }
            next=curr;
        }
        int min=(int) Math.pow(10,9);
        for (int i = 0; i < next.length; i++) {
            min=Math.min(min,next[i]);
        }
        return min;
    }
}
