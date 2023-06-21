package Arrays;
import java.util.Arrays;
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//typically using all the original letters exactly once.
public class ValidAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s,t));
    }
    //O(NlogN)
    public boolean isAnagram1(String s, String t) {
        char[] x=s.toCharArray();
        char[] y=t.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        if(s.length()!=t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(x[i]!=y[i]){
                return false;
            }
        }
        return true;
    }
    //O(2N)
    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] store=new int[26];  //stores the total no. of appearances of a character
        for (int i=0;i<s.length();i++){
            //we are increasing the total no. of appearances of a character in the array
            store[s.charAt(i)-'a']++;
            //we are decreasing the total no. of appearances of a character in the array
            store[t.charAt(i)-'a']--;
            //if it's an anagram, the result arr will have 0 in all places
        }

        for (int i:store){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
