package String;

public class LongestRepeatingCharReplace {
    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {
        int[] arr=new int[26];
        int left=0;
        int maxFrequency=0;
        int maxRes=0;
        for(int right=0; right<s.length(); right++){
            arr[s.charAt(right)-'A']++;
            int cur=arr[s.charAt(right)-'A'];
            maxFrequency=Math.max(maxFrequency,cur);

            while(right-left+1 -maxFrequency>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            maxRes=Math.max(maxRes,right-left+1);
        }
        return maxRes;
    }
}
