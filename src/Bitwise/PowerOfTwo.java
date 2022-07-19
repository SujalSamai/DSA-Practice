package Bitwise;
//https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
//Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some x.
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }

    public static boolean isPowerOfTwo(long n){
        if(n==0) return false;
        if((n&(n-1))==0){
            return true;     // eg. n=64=> 1000000, n-1=63=>111111  if we & them we will get 0
        }
        return false;
    }
}
