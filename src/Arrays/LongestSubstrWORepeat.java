package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWORepeat {
    //O(2N)
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxAns=Integer.MIN_VALUE;
        Set<Character> set=new HashSet<>();
        int left=0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxAns=Math.max(maxAns,right-left+1);
        }
        return maxAns;
    }

    //O(N)
    public int lengthOfLongestSubstring2(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0, right=0;
        int len=0;
        while (right<s.length()){
            if (map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right),right);
            len=Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
}
