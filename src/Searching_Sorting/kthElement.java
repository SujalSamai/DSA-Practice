package Searching_Sorting;

import java.util.Arrays;

public class kthElement {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k=5;
        System.out.println(kElement(arr1,arr2, arr1.length, arr2.length, k));
    }
    static long kElement(int[] arr1, int[] arr2, int n, int m, int k) {
        long[] ans=new long[n+m];
        int x=0;
        for (int el:arr1){
            ans[x++]=el;
        }
        for (int el:arr2){
            ans[x++]=el;
        }

        Arrays.sort(ans);
        return ans[k-1];
    }
}
