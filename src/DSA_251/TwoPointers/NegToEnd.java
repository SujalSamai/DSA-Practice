package DSA_251.TwoPointers;

import java.util.Arrays;

public class NegToEnd {
    public static void main(String[] args) {
        int[] arr={1,-4,-2,5,3};
        System.out.println(Arrays.toString(separateNegativeAndPositive(arr)));
    }
    public static int[] separateNegativeAndPositive(int[] a) {
        int start = 0;
        int end = a.length-1;
        while(start < end){
            if(a[start] >= 0 && a[end]<0){
                int temp= a[start];
                a[start]=a[end];
                a[end]=temp;
                start++;
                end--;
            }else if(a[start] < 0){
                start++;
            }else {
                end--;
            }
        }
        return a;
    }
}
