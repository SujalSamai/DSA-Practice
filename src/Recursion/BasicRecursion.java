package Recursion;

public class BasicRecursion {
    public static void main(String[] args) {
//        printNum(5);
//        System.out.println(factorial(5));
        reverse(1352);
    }
    public static void printNum(int n){
        if(n<1){
            return;
        }
        printNum(n-1);
        System.out.println(n);
//        printNum(n-1);
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int product(int n){
        if(n%10==n){  //becomes true only when last digit is remaining, as n%10 will always be a single digit
            return n;
        }
        return (n%10)* product(n/10);
    }

    public static void reverse(int n){
        int sum=0;
        reverseHelper(n,sum);
    }
    public static void reverseHelper(int n, int sum){
        if(n==0){
            System.out.println(sum);
            return;
        }
        int rem=n%10;
        sum=sum*10+rem;
        reverseHelper(n/10,sum);
    }
}
