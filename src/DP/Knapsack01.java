package DP;
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int size= sc.nextInt();
        int[] profit= new int[size];
        int[] weight= new int[size];
        System.out.print("Enter the weight of items: ");
        for (int i=0; i<size; i++){
            weight[i]=sc.nextInt();
        }
        System.out.print("Enter the profits associated with them: ");
        for (int i=0; i<size; i++){
            profit[i]=sc.nextInt();
        }
        System.out.print("Enter the capacity of Knapsack: ");
        int W = sc.nextInt();
        System.out.print(knapSack2(W, weight, profit, size));
    }
    //memoization
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp=new int[n][W+1];
        for (int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return knapSackUtil(wt,val,n-1,W,dp);
    }

    private static int knapSackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if(ind==0) {
            if (wt[0]<=W) return val[0];
            else return 0;
        }
        if (dp[ind][W]!=-1) return dp[ind][W];
        int notTaken=knapSackUtil(wt,val,ind-1,W,dp);
        int taken=Integer.MIN_VALUE;
        if (wt[ind]<=W) taken=val[ind]+ knapSackUtil(wt,val,ind-1,W-wt[ind],dp);
        return dp[ind][W]=Math.max(notTaken,taken);
    }

    //tabulation
    static int knapSack2(int W,int[] wt, int[] val, int n){
        int[][] dp=new int[n][W+1];
        for (int i = wt[0]; i <=W ; i++) {
            dp[0][i]=val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                int notTaken=dp[ind-1][cap];
                int taken=Integer.MIN_VALUE;
                if (wt[ind]<=cap) taken=val[ind]+dp[ind-1][cap-wt[ind]];
                dp[ind][cap]=Math.max(notTaken,taken);
            }
        }
        return dp[n-1][W];
    }

    //space optimized
    static int knapSack3(int W, int[] wt, int[] val, int n){
        int[] prev=new int[W+1];
        for (int i = wt[0]; i <=W ; i++) {
            prev[i]=val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                int notTaken=prev[cap];
                int taken=Integer.MIN_VALUE;
                if (wt[ind]<=cap) taken=val[ind]+prev[cap-wt[ind]];
                prev[cap]=Math.max(notTaken,taken);
            }
        }
        return prev[W];
    }
}
