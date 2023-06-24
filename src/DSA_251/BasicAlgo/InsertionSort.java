package DSA_251.BasicAlgo;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = { 9, 5, 1, 4, 3 };
        insertionSort(data.length, data);
        System.out.println(Arrays.toString(data));
    }
    public static void insertionSort(int n , int[] arr) {
        for (int i = 1; i < n; i++) {
            int key= arr[i];
            int j= i-1;

            // Compare key with each element on the left of it until an element smaller than it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j>=0 && key<arr[j]){
                arr[j+1]= arr[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            arr[j+1] = key;
        }
    }
}
