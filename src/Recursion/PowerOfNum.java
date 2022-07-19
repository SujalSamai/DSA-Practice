package Recursion;

public class PowerOfNum {
    public static void main(String[] args) {
        int n= 256;
//        System.out.println(isPowerOfTwo(n));
//        System.out.println(isPowerOfTwo2(n));
        System.out.println(isPowerOfThree(n));
        System.out.println(isPowerOfFour(n));
    }
    //recursion
    public static boolean isPowerOfTwo(int n){
        if(n==1)
            return true;
        if(n%2==1||n<1)
            return false;
        return isPowerOfTwo(n/2);
    }

    //bit manipulation
    public static boolean isPowerOfTwo2(int n){
        //if n is power of two, it can contain only one 1 in binary form for eg. 4=100, 8=1000
        return (n>0 && (n&(n-1))==0);  //n&(n-1) removes the last 1 in binary form of n
    }

    public static boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        if(n%3!=0 || n<1){
            return false;
        }
        return isPowerOfThree(n/3);
    }

    public static boolean isPowerOfFour(int n) {
        if(n==1){
            return true;
        }
        if(n%4!=0 || n<1){
            return false;
        }
        return isPowerOfFour(n/4);
    }
}
