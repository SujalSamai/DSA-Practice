package DSA_251.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String str1= "ABC";
        String str2= "AHBDC";
        System.out.println(isSubsequence(str1, str2));
    }
    public static String isSubsequence(String str1, String str2) {
        if(str2.length()<str1.length()) return str1;
        int i=0, j=0, count=0;
        while (i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                i++;
                j++;
                count++;
            }else{
                j++;
            }
        }
        if(count== str1.length()) return "True";
        else return "False";
    }
}
