package Bitwise;
//https://leetcode.com/problems/sum-of-two-integers/
//Given two integers a and b, return the sum of the two integers without using the operators + and -.
public class SumOfTwoNum {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        System.out.println(getSum(a,b));
    }
    /*Key point-> an XOR operator can add two numbers if adding their binary equivalent don't generate any carry bit
    for eg. 1^2=>001^010=>3(011). But when we have carry it can't handle that
    so we will generate carry using AND operator. Note carry is generated only when the bits are set i.e. (1,1)
    now we need to add it to the XOR value, but the carry should be added to the left bit of the one which generated it.
    so we left shift it by one so that it gets added at the right spot.
    After this we will again XOR the new values until carry becomes zero*/

    //for better understanding-> https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
    public static int getSum(int a, int b) {
        int carry;
        while(b !=0 ) {
            carry = (a&b);
            a = a ^ b;
            b = (carry)<<1;
        }
        return a;
    }
}
