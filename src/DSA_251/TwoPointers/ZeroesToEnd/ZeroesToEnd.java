package DSA_251.TwoPointers.ZeroesToEnd;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroesToEnd {
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(2);
        arr.add(0);
        arr.add(4);
        arr.add(1);
        arr.add(3);
        arr.add(0);
        arr.add(28);
        pushZerosAtEnd(arr);
    }

    //repeatedly swaps numbers if it is non zero
    // for 2 it'll just increase pointer, when 0 is encounter pointer will not increase & iteration continues
    //iteration reaches 4, pointer is stuck at 0, swap numbers continuously till again 0 is reached
    //2,4,1,4,0,0,28, pointer will be stuck at first 0, iteration will reach 28, swap pointer with 28
    public static void pushZerosAtEnd(ArrayList<Integer> arr) {
        int nonZero=0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)!=0){
                int temp=arr.get(i);
                arr.set(i, arr.get(nonZero));
                arr.set(nonZero, temp);
                nonZero++;
            }
        }
    }
}
