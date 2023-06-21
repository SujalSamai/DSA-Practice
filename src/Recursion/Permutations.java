package Recursion;
//https://leetcode.com/problems/permutations
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //Approach 1 -> TC- n!*n SC- O(n)+O(n)
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[] freq=new boolean[nums.length];  //tracks which number is being used currently and which is not
        recurPermute(nums,ds,freq,ans);
        return ans;
    }

    private void recurPermute(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> ans) {
        if (ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums,ds,freq,ans);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }

    //Approach 2 -> TC- O(n!*n) SC- no extra space, only auxiliary space
    public List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recurPermute2(0,nums,ans);
        return ans;
    }

    private void recurPermute2(int index, int[] nums, List<List<Integer>> ans) {
        if (index== nums.length){
            List<Integer> ds=new ArrayList<>();
            //copy the swapped arr to ds
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i <nums.length ; i++) {
            swap(i,index,nums);
            recurPermute2(index+1,nums,ans);
            //reswap so that everything gets back to original place
            swap(i,index,nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
