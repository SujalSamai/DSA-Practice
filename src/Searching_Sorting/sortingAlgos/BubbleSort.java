package Searching_Sorting.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={2,4,7,1,5,3};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble(int[] arr){
        boolean swapped;
        for (int i=0; i<arr.length;i++){
            swapped=false;
            for (int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    swapped=true;
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
            if(!swapped)
                break;
        }
    }
}
