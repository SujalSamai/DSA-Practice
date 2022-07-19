package Maths;
//https://leetcode.com/problems/reverse-integer/
//https://www.interviewbit.com/problems/reverse-integer/
//Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
//        System.out.println(Integer.MAX_VALUE/10);
    }
    public static int reverse(int A){
        int num= 0;
        int rem=0;
        while(A != 0) {
            if(num>Integer.MAX_VALUE/10 || num<Integer.MIN_VALUE/10){
                return 0;
            }
            rem = A % 10;
            num = (num * 10) + rem;
            A = A / 10;
        }
        return num;
    }
}
