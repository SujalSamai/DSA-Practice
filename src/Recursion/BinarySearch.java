package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        int target= 9;
        System.out.println(bSearch(nums,target,0, nums.length));
    }
    public static int bSearch(int[] nums, int target, int s, int e){
        if (s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]>target){
                return bSearch(nums,target,s,mid-1);
            }
            else if(nums[mid]<target){
                return bSearch(nums, target,mid+1, e);
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
