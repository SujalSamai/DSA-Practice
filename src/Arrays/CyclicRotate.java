package Arrays;

import java.awt.dnd.DropTarget;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
//Given an array, rotate the array by one position in clock-wise direction.
public class CyclicRotate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotate(arr,arr.length);
    }

    public static void rotate(int[] arr, int n){
        for (int i=0; i<n;i++){
            int temp=arr[n-1];
            arr[n-1]=arr[i];
            arr[i]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
