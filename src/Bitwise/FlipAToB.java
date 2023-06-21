package Bitwise;
//https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
//You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
public class FlipAToB {
    public static void main(String[] args) {
        System.out.println(countBitsFlip(10,20));
    }
    //for eg- 10=>01010 20=>10100   if we do 10^20=> 11110  1 denotes the places where the bits are different in both the numbers.
    //As 0^1=> 1 and 1^0=>1
    //Now each time we do xor&(xor-1) one of the 1 is reduced from the xor and we increment count value

    static int countBitsFlip(int a, int b){
        int xor= a^b;
        int res=0;
        while (xor>0){
            xor=xor&(xor-1);
            res++;
        }
        return res;
    }
}
