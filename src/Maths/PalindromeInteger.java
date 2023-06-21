package Maths;
//https://www.interviewbit.com/problems/palindrome-integer/
//Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(isPalindrome(2147447412));
    }

    public static int isPalindrome(int A){
        int num= 0;
        int temp=A;
        int rem=0;
        while(temp>0) {
            rem = temp % 10;
            num = (num * 10) + rem;
            temp = temp / 10;
        }
        if(num==A){
            return 1;
        }
        return 0;
    }
}
