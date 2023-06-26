package DSA_251.BasicAlgo.SelectionSort;

public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            //finding the minimum element in the array
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            //if minimum element found, swap it with the current index
            int temp= arr[i];
            arr[i]= arr[min];
            arr[min]=temp;
        }
    }
}
