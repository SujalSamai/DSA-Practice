package Recursion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] c={'h','e','l','l','o'};
        reverse(c,0,c.length-1);
    }
    public static void reverse(char[] s,int l, int r){
        if(l>r){
            System.out.println(Arrays.toString(s));
            return;
        }
        char c=s[l];
        s[l]= s[r];
        s[r]=c;
        reverse(s, ++l, --r);
    }
}
