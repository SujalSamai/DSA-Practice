package Heaps.Implementation;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={12, 11, 13, 5, 6, 7};
        heapSortMax(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSortMax(int[] a){
        int n=a.length;
        //Build heap
        for (int i = (n/2)-1; i >=0 ; i--) {
            maxHeapify(a,n,i);
        }
        // One by one extract an element from heap
        for (int i = n-1; i >0 ; i--) {
            // Move current root to end
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            // call max heapify on the reduced heap
            maxHeapify(a,i,0);
        }
    }

    static void maxHeapify(int[] arr,int n, int i) {
        int l=2*i+1;
        int r=2*i+2;
        int largest=i;
        if(l<n && arr[l]>arr[largest]){
            largest=l;
        }

        if(r<n && arr[r]>arr[largest]){
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
