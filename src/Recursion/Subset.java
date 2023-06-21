package Recursion;
//https://leetcode.com/problems/subsets
import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> innerRes=new ArrayList<>();

        findSubsets(nums,0,res,innerRes);
        return res;
    }

    private static void findSubsets(int[] nums, int index, List<List<Integer>> res, List<Integer> innerRes) {
        if (index== nums.length){
            res.add(new ArrayList<>(innerRes));
            return;
        }

        innerRes.add(nums[index]);
        findSubsets(nums,index+1,res,innerRes);
        innerRes.remove(innerRes.size()-1);
        findSubsets(nums,index+1,res,innerRes);
    }
}
