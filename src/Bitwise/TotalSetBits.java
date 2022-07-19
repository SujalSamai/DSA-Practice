package Bitwise;
//https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1#
//You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
public class TotalSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(17));
    }
    public static int countSetBits(int n){
        //O(n) solution
        int[] bitsCount=new int[n+1];
        int sum=0;
        bitsCount[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                bitsCount[i]=bitsCount[i/2];  // i/2-> means i>>1, we know even numbers have LSB=0, so even number(i) has same set bits as i/2
            }
            else{
                bitsCount[i]=1+bitsCount[i/2]; //odd numbers have LSB=1, so odd number(i) has i+ set bits of(i/2)
            }
            sum+=bitsCount[i];
        }

        return sum;
    }

    //O(logn) yet to understand
    public static int countBits(int n){
        n++;

        // To store the powers of 2
        int powerOf2 = 2;

        // To store the result, it is initialized
        // with n/2 because the count of set
        // least significant bits in the integers
        // from 1 to n is n/2
        int cnt = n / 2;

        // Loop for every bit required to represent n
        while (powerOf2 <= n)
        {

            // Total count of pairs of 0s and 1s
            int totalPairs = n / powerOf2;

            // totalPairs/2 gives the complete
            // count of the pairs of 1s
            // Multiplying it with the current power
            // of 2 will give the count of
            // 1s in the current bit
            cnt += (totalPairs / 2) * powerOf2;

            // If the count of pairs was odd then
            // add the remaining 1s which could
            // not be groupped together
            cnt += (totalPairs % 2 == 1) ?
                    (n % powerOf2) : 0;

            // Next power of 2
            powerOf2 <<= 1;
        }

        // Return the result
        return cnt;
    }
}
