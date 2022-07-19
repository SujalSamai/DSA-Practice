package Maths;

// https://www.interviewbit.com/problems/greatest-common-divisor/
//Given 2 non negative integers m and n, find gcd(m, n)
//Maths.GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(3,9));
    }

    public static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}
