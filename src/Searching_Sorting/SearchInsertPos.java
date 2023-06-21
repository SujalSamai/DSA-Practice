package Searching_Sorting;

public class SearchInsertPos {
    public static void main(String[] args) {
        int[] nums={1,3,5,6,8,9};
        int target=7;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target){
        int start=0, mid=0;
        int end=nums.length-1;
        while (start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        //if result doesn't comes from this while loop then it will execute this portion
        //mid will automatically come to the one position before where the element if existed would have been there, so just add 1
        if(nums[mid]<target){
            mid=mid+1;
        }
        return mid;
    }
}
