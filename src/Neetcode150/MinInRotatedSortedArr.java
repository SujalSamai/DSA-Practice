package Neetcode150;

public class MinInRotatedSortedArr {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums){
        int left=0;
        int right= nums.length-1;
        while (left<=right){
            if (nums[left]<=nums[right]) return nums[left];
            int mid = (left+right)/2;

            if (nums[mid]>=nums[left]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return 0;
    }
}
