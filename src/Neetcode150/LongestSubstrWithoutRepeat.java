package Neetcode150;

import java.util.HashSet;

public class LongestSubstrWithoutRepeat {
    public static int lengthOfLongestSubstring(String s){
        if (s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxAns = Integer.MIN_VALUE;
        for (int i=0; i<s.length(); i++){
            if (set.contains(s.charAt(i))){
                while (left< i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(i));
            maxAns = Math.max(maxAns, i - left + 1);
        }
        return maxAns;
    }
}
