package Neetcode150;

import java.util.HashSet;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int count=0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curStreak = 1;
                while(set.contains(curNum+1)){
                    curStreak+=1;
                    curNum+=1;
                }
                count = Math.max(count, curStreak);
            }
        }
        return count;
    }
}
