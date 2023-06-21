package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums){
        Set<Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int streak=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int curNum=num;
                int curStreak=1;
                while (set.contains(curNum + 1)) {
                    curNum+=1;
                    curStreak+=1;
                }
                streak=Math.max(streak,curStreak);
            }
        }
        return streak;
    }
}
