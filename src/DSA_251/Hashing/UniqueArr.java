package DSA_251.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueArr {
    public static int minElementsToRemove(ArrayList<Integer> arr) {
        int count=0;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0; i<arr.size(); i++){
            if(set.contains(arr.get(i))){
                count++;
            }else{
                set.add(arr.get(i));
            }
        }
        return count;
    }
}
