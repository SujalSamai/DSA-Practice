package Bitwise;
//https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
//Given a number N having only one ‘1’ and all other ’0’s in its binary representation, find position of the only set bit. If there are 0 or more than 1 set bit the answer should be -1.
// Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.
public class SetBitPosition {
    public static void main(String[] args) {
        System.out.println(findPosition(4));
    }

    static int findPosition(int N) {
        if(N==0) return -1;
        int count=0;
        int pos=1;
        for (int i=0; i<32; i++){
            if((N&1)==1){
                count++;
            }
            if(count==0){
                pos++;
            }
            N=N>>1;
        }
        if(count>1){
            return -1;
        }else{
            return pos;
        }
    }
}
