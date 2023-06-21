package Searching_Sorting;

public class MinInSortedArr {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums){
        int left=0;
        int right= nums.length-1;
        while (left<= right){
            if (nums[left]<=nums[right]){
                return nums[left];
            }
            int mid=(left+right)/2;
            //if mid is greater than left, then we can't find min element at left side
            if(nums[mid]>=nums[left]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return 0;
    }
}
