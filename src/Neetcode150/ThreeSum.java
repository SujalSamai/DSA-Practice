package Neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])){
                int target = -nums[i];
                int left = i+1;
                int right = nums.length-1;

                while (left<right){
                    if (nums[left] + nums[right] == target){
                        ArrayList<Integer> mini = new ArrayList<>();
                        mini.add(nums[i]);
                        mini.add(nums[left]);
                        mini.add(nums[right]);
                        res.add(mini);

                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(nums[left]+nums[right] > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
