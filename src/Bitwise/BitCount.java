package Bitwise;

import java.util.Arrays;

public class BitCount {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(9)));
    }
    public static int[] countBits(int n){
        int[] bitsCount=new int[n+1];
        bitsCount[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                bitsCount[i]=bitsCount[i/2];  // i/2-> means i>>1, we know even numbers have LSB=0, so even number(i) has same set bits as i/2
            }
            else{
                bitsCount[i]=1+bitsCount[i/2]; //odd numbers have LSB=1, so odd number(i) has i+ set bits of(i/2)
            }
        }
        return bitsCount;
    }
}
