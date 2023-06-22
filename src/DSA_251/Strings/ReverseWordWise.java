package DSA_251.Strings;

import java.util.Arrays;

public class ReverseWordWise {
    public static void main(String[] args) {
        String str="Always indent your code";
        System.out.println(reverseStringWordWise(str));
    }
    static String reverseStringWordWise(String input) {
        String[] s= input.split(" ");
        StringBuilder ss=new StringBuilder();
        for (int i= s.length-1; i>=0; i--){
            ss.append(s[i]+" ");
        }
        return ss.toString();
    }
}
