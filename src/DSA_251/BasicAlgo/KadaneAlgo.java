package DSA_251.BasicAlgo;

public class KadaneAlgo {
    public static long maxSubarraySum(int[] arr, int n) {
        long curSum=0, maxSum= arr[0];
        for (int i = 0; i < n; i++) {
            curSum+=arr[i];
            if(curSum<0){
                curSum=0;
            }
            maxSum= Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
