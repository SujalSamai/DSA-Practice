package Maths;
//https://leetcode.com/problems/happy-number/
//Write an algorithm to determine if a number n is happy.
//A happy number is a number defined by the following process:
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
public class HappyNumber {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n){
        if (n<7 && n>1)  return false; //a number between 2 and 6 can never generate the sum as 1
        int res=0;
        //base condition
        if(n==1){
            return true;
        }
        while (n>0){
            int rem=n%10;
            res=res+(rem*rem);
            n=n/10;
        }
        return isHappy(res);
    }
}
