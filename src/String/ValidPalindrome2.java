package String;

public class ValidPalindrome2 {
    public static void main(String[] args) {

    }
    public static boolean validPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while (l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return (isPalindrome(s,l,r-1)||(isPalindrome(s,l+1,r)));
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
