package Neetcode150;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if ((s.charAt(i)>='0' && s.charAt(i)<='9') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')) {
                str.append(s.charAt(i));
            }
        }

        String res = str.toString().toLowerCase();
        //check if it is a valid palindrome or not
        int x=0, y=res.length()-1;

        while (x<=y) {
            if (res.charAt(x)==res.charAt(y)) {
                x++;
                y--;
            }else{
                return false;
            }
        }
        return true;
    }
}
