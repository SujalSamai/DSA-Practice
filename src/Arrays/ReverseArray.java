package Arrays;
//https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
//Difficulty level: Basic
//Question: Given an array (or string), the task is to reverse the array/string.
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr={4,2,5,7,2,6,1};
        reverse(arr);
    }
    static void reverse(int[] arr){
        int l=0;
        int r=arr.length-1;
        int i=0;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++; r--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
