package Bitwise;

public class SetBits {
    public static void main(String[] args) {
        int n=128;
        System.out.println(countSetBits(n));
    }

    public static int countSetBits(int n){
        int count=0;
        for (int i=0; i<32;i++){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}
