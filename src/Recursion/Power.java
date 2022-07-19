package Recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow2(5,5));
    }
    //Recursion
    public static double myPow(double x, int n){
        if(n==0){
            return 1;
        }
        else if( n > 0) {
            if(n%2 == 0) {
                return myPow(x*x , n/2);
            }
            else {
                return myPow(x*x, (n-1)/2) * x;    //for n==1, this will return 1 as (n-1)/2=> 0
            }
        }
        else {
            if(n%2 == 0) {
                return myPow(x*x , n/2);
            }
            else {
                return myPow(x*x, (n+1)/2)* (1/x) ;
            }
        }
    }

    //Optimised
    public static double myPow2(double x, int n) {
        double ans = 1;
        long num = n;  //long to take care of overflows of edge cases

        if (num < 0) num = -1*num;

        while (num > 0){
            if (num%2 == 1){
                ans = ans*x;
                num =num- 1;
            }
            else{
                x = x*x;
                num =num/2;
            }
        }

        if (n < 0)
            ans = (double)(1.0) / (double)(ans);

        return ans;
    }
}
