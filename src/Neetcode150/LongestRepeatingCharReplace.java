package Neetcode150;

public class LongestRepeatingCharReplace {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    /*Calculate and store the occurence of each character in our array, we will use a sliding window approach
    We will keep hold of the maximum Frequency we have achieved till now for a character
    Now if our current range - maxFrequency > k (for eg: AABAB, maxFrequency=3, currRange=5, 5-3=1) then we will do sliding
    We will remove one character from beginning & increment left pointer
    At the end, we will get maxRange that satisfies our condition*/

    public static int characterReplacement(String s, int k){
        int[] arr = new int[26];
        int maxRes = 0;
        int maxFrequency = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right)-'A']++;
            int cur = arr[s.charAt(right)-'A'];
            maxFrequency = Math.max(maxFrequency, cur);
            if ((right-left+1)-maxFrequency > k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxRes = Math.max(maxRes, right-left+1);
        }
        return maxRes;
    }
}
