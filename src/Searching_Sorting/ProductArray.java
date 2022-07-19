package Searching_Sorting;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        int[] nums={10,3,5,6,2};
        System.out.println(Arrays.toString(productExceptSelf(nums, nums.length)));
    }
    public static long[] productExceptSelf(int[] nums,int n){
        long[] P =new long[n];
        long[] l =new long[n];
        long[] r =new long[n];
        l[0]=1;
        r[n-1]=1;
        // from left to right multiplication
        for(int i=1;i<n;i++){
            l[i]=nums[i-1]*l[i-1];
        }
        // from right to left multiplication
        for(int i=n-2;i>=0;i--){
            r[i]=nums[i+1]*r[i+1];
        }
        for(int i=0;i<n;i++){
            P[i]=l[i]*r[i];
        }
        return P;
    }
}
