package Arrays;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate2(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length;i++){
            if(nums[i]==nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums){
        HashSet<Integer> set= new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
