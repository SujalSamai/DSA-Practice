package Searching_Sorting;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr={1,-1,2,-4};
        System.out.println(threeSumClosest(arr,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // -4 -1  1  2
        int minDiff= Integer.MAX_VALUE;
        int res=0;
        for (int i=0; i<nums.length-2; i++){
            int left= i+1;
            int right=nums.length-1;

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];

                if(sum==target){
                    return target;
                }
                if(sum<target){
                    if(target-sum<minDiff){
                        minDiff=target-sum;
                        res=sum;
                    }
                    left++;
                }
                else {
                    if(sum-target<minDiff){
                        minDiff=sum-target;
                        res=sum;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
