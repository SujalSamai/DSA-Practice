package Heaps.Implementation;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        int[] arr={ 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        buildMaxHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void buildMaxHeap(int[] arr,int n){
        for (int i = (n/2)-1; i >=0 ; i--) {
            maxHeapify(arr,n,i);
        }
    }

    public static void maxHeapify(int[] arr,int n, int i) {
        int l=2*i+1;
        int r=2*i+2;
        int largest=i;
        if(l<arr.length && arr[l]>arr[largest]){
            largest=l;
        }

        if(r< arr.length && arr[r]>arr[largest]){
            largest=r;
        }

        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            maxHeapify(arr,n,largest);
        }
    }
}
