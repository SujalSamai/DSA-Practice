package Neetcode150;

public class CountingBits {
    // 0 -> 0
    // 1 -> 01
    // 2 -> 10
    // 3 -> 11
    // 4 -> 100
    // 5 -> 101
    // 6 -> 110
    // 7 -> 111
    // 8 -> 1000
    // 9 -> 1001
    // 10 -> 1010
    public static int[] countBits(int n){
        int[] bitsCount = new int[n+1];
        bitsCount[0] = 0;
        for (int i=1; i<=n; i++){
            if (i%2==0){    // i/2-> means i>>1, we know even numbers have LSB=0, so even number(i) has same set bits as i/2
                bitsCount[i]= bitsCount[i/2];
            }else {     //odd numbers have LSB=1, so odd number(i) has i+ set bits of(i/2)
                bitsCount[i] = 1 + bitsCount[i/2];
            }
        }
        return bitsCount;
    }
}
