package DSA_251.Arrays.MissingRepeating;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingAndRepeating {
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(6);
        arr.add(4);
        arr.add(3);
        arr.add(5);
        arr.add(5);
        arr.add(1);
        System.out.println(Arrays.toString(missingAndRepeating(arr, arr.size())));
    }
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] countOccurrences = new int[n];
        for (int i = 0; i < n; i++) {
            countOccurrences[arr.get(i)-1]++;
        }
        int[] res= new int[2];
        for (int i = 0; i < n; i++) {
            if(countOccurrences[i]==0){
                res[0]=i+1;
            }
            if(countOccurrences[i]==2){
                res[1]=i+1;
            }
        }
        return res;
    }
}
