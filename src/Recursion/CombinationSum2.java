package Recursion;
//https://leetcode.com/problems/combination-sum-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> list) {
        if (target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i>index && candidates[i]==candidates[i-1]) continue;
            if (candidates[i]>target) break;

            list.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],ans,list);
            list.remove(list.size()-1);
        }
    }
}
