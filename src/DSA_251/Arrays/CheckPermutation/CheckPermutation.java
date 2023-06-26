package DSA_251.Arrays.CheckPermutation;


public class CheckPermutation {
    public static boolean areAnagram(String str1, String str2){
        if(str1.length()!= str2.length()) return false;
        int[] arr1 = new int[26];
        for (int i=0;i<str1.length();i++) {
            arr1[str1.charAt(i)-'a']++;
            arr1[str2.charAt(i)-'a']--;
        }
        for (int i=0;i<26;i++) {
            if (arr1[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
