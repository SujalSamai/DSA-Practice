package Searching_Sorting.sortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={5,2,3,6,8,1,7};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertion(int[] arr){
        for (int i=1; i<arr.length; i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}
