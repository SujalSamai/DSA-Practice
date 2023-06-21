package Maths;
//https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
//Given an integer A, return the number of trailing zeroes in A!.
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailing(28));
    }
    public static int trailing(int n){
        int res=0;
        for (int i=5; i<=n; i=i*5){
            res=res+ n/i;
        }
        return res;
    }
}
