package Arrays;
/*https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
https://leetcode.com/problems/kth-largest-element-in-an-array/
Given an array arr[] and an integer K where K is smaller than size of array,
the task is to find the Kth smallest and largest element in the given array.
It is given that all array elements are distinct. */
import java.util.Arrays;

public class kthMaxMin {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,6,4};
        System.out.println(findkthLargest(arr,2));
    }
    //O(nlogn) solutions - Arrays.sort uses Quick Sort(Dual Pivot) in Java
    static int findkthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[(nums.length)-k];
    }
    static int findkthSmallest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[k-1];
    }
}
