package Searching_Sorting.sortingAlgos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={4,3,12,9,6,1,7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[]arr,int l,int h){
        int i=l;
        int j=h;
        //taking pivot element as middle to increase chances of algorithm getting optimised
        int m=i+(j-i)/2;
        int pivot=arr[m];
        while(i<j){
            //if the element is less than or equal to pivot
            while(arr[i]<=pivot && i<=h-1){
                i++;
            }
            //if element is greater than pivot
            while (arr[j]>pivot && j>=l){
                j--;
            }
            //if element at left is > pivot and element at right is < pivot and i<j swap them
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //put pivot to its actual position by swapping j and pivot, as j has reached to pivot's actual position
        int temp=arr[m];
        arr[m]=arr[j];
        arr[j]=temp;
        return j;
    }
    public static void quickSort(int[] arr, int l, int h){
        if(l<h){
            int pivot=partition(arr,l,h);
            //left side of pivot
            quickSort(arr,l,pivot-1);
            //right side of pivot
            quickSort(arr,pivot+1,h);
        }
    }
}
