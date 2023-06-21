package Recursion;
//https://leetcode.com/problems/subsets-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //to bring together the duplicates side by side
        List<List<Integer>> ans=new ArrayList<>();
        findSubsets(0,nums,new ArrayList<Integer>(), ans);
        return ans;
    }

    private static void findSubsets(int index, int[] nums, ArrayList<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i!=index && nums[i]==nums[i-1]) continue;    //if duplicate found skip
            list.add(nums[i]);
            findSubsets(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
}
