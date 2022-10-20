package Searching_Sorting;
//https://leetcode.com/problems/product-of-array-except-self/
import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        int[] nums={10,3,5,6,2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] res= new int[n];
        res[0]=1;

        for( int i=1; i<n; i++ ){
            res[i]=res[i-1]*nums[i-1];
        }

        int r=1;

        for( int i=n-1; i>=0; i-- ){
            res[i]=res[i]*r;
            r=r*nums[i];
        }

        return res;
    }
}
