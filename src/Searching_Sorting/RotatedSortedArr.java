package Searching_Sorting;

public class RotatedSortedArr {
    public static void main(String[] args) {
        int[] arr={4,5,6,0,1,2,3};
        int target=1;
        System.out.println(search(arr,target));
    }
    //rotated Binary search
    static public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]==target) {
                return mid;
            }
//            boolean leftSorted = isSorted(nums,start,mid);// checks if left part(including mid elem) is sorted or not
            boolean leftSorted= nums[start] <= nums[mid];
            if(leftSorted) {
                if(target>=nums[start] && target<nums[mid])// target lies in the sorted left half
                    end = mid - 1;
                else
                    start = mid+1; // target lies in the unsorted right half
            }
            else{ //right sorted
                if(target>nums[mid] && target<=nums[end]) //target lies in the sorted-right part
                    start = mid+1;
                else
                    end = mid-1; // target lies in the unsorted left part
            }
        }
        return -1;
    }
//    static boolean isSorted(int[] nums,int start,int mid)
//    {
//        return nums[start] <= nums[mid];
//    }
}
