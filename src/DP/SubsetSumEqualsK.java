package DP;
//https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
import java.util.Arrays;

public class SubsetSumEqualsK {
    //Memoization Time Complexity: O(N*K), Space Complexity: O(N*K) + O(N)

    static boolean subsetSumToK(int n,int k, int[] arr){
        int[][] dp=new int[n][k+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return subsetSumUtil(n-1,k,arr,dp);
    }

    private static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        if (target==0) return true;
        if (ind==0) return arr[0]==target;
        if (dp[ind][target]!=-1) return dp[ind][target] != 0;

        boolean notTaken= subsetSumUtil(ind-1, target,arr,dp);
        boolean take=false;
        if (arr[ind]<=target){
            take=subsetSumUtil(ind-1, target-arr[ind],arr,dp);
            dp[ind][target]=notTaken || take ? 1:0;
        }
        return notTaken || take;
    }

    //Tabulation - Time Complexity: O(N*K), Space Complexity: O(N*K)
    static boolean subsetSumToK2(int n, int k, int[] arr){
        boolean[][] dp=new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }
        if (arr[0]<=k){
            dp[0][arr[0]]=true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <=k ; target++) {
                boolean notTaken=dp[ind-1][target];

                boolean taken=false;
                if (arr[ind]<=target){
                    taken=dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]=notTaken|| taken;
            }
        }
        return dp[n-1][k];
    }

    //Space Optimized
    static boolean subsetSumToK3(int n, int k, int[] arr){
        boolean[] prev=new boolean[k+1];
        prev[0]=true;

        if (arr[0]<=k){
            prev[arr[0]]=true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur=new boolean[k+1];
            cur[0]=true;
            for (int target = 1; target <=k; target++) {
                boolean notTaken=prev[target];

                boolean taken=false;
                if (arr[ind]<=target){
                    taken=prev[target-arr[ind]];
                }
                cur[target]=taken||notTaken;
            }
            prev=cur;
        }
        return prev[k];
    }
}
