package Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
//An array contains both positive and negative numbers in random order.
// Rearrange the array elements so that all negative numbers appear before all positive numbers.
//Note: Order of elements is not important here.
public class NegtoLeft {
    public static void main(String[] args) {
        int[] arr={-12,11,-13,-5,6,-7,5,-3,-6};
        left(arr);
    }
    //Basic two pointer approach
    static void left(int[] arr){
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if(arr[l]<arr[r]){
                l++;
            }
            else if(arr[l]>arr[r]){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                r--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
