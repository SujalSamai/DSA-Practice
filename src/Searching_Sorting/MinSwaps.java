package Searching_Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwaps {
    public static void main(String[] args) {
        int[] nums = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(nums));
    }
    public static int minSwaps(int[] arr){
        int n=arr.length;
        int[] a=new int[n];
        //copying the array
        for (int i=0; i<n; i++){
            a[i]=arr[i];
        }
        Arrays.sort(a);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<n;i++){
            map.put(a[i],i);     //putting the index element and mapping it to the index
        }
        int count=0;
        for (int i=0; i<n; i++){
            //compares the given array with sorted array
            //if any differences in positions are found, it gets counted and then swapped
            //it works like this-> map.get(arr[1])-> arr[1]=8 -> map.get(8)->3 which is not equal to i which is 1
            while (map.get(arr[i])!=i){
                count++;
                //swapping so that 1 swap doesn't gets counted twice
                int el=map.get(arr[i]);
                int temp=arr[el];
                arr[el]=arr[i];
                arr[i]=temp;
            }
        }
        return count;
    }
}
