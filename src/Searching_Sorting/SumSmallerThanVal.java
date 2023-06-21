package Searching_Sorting;

import java.util.Arrays;

public class SumSmallerThanVal {
    public static void main(String[] args) {
        long[] arr = {-2, 0, 1, 3};
        int sum=2;
        System.out.println(countTriplets(arr,arr.length,sum));
    }
    static long countTriplets(long[] arr, int n,int sum) {
        Arrays.sort(arr);
        long ans=0;
        for (int i=0; i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while (j<k){
                if(arr[i]+arr[j]+arr[k]<sum){
                    //all the numbers in the range k-j will be smaller than sum
                    ans+=(k-j);
                    j++;
                }else {
                    k--;
                }
            }
        }
        return ans;
    }
}
