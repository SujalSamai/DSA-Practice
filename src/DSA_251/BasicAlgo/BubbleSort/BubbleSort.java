package DSA_251.BasicAlgo.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={5,6,2,7,1,3};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr, int n) {
        //with each complete iteration, the lowest element goes to its correct position
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n ; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
