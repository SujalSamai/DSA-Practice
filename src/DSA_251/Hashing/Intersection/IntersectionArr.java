package DSA_251.Hashing.Intersection;

import java.util.ArrayList;
import java.util.Objects;

public class IntersectionArr {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        int ptr1=0, ptr2=0;
        ArrayList<Integer> res= new ArrayList<>();
        while (ptr1<arr1.size() && ptr2<arr2.size()){
            if(arr1.get(ptr1).equals(arr2.get(ptr2))){
                res.add(arr1.get(ptr1));
                ptr1++;
                ptr2++;
            }else if(arr1.get(ptr1)<arr2.get(ptr2)){
                ptr1++;
            }else{
                ptr2++;
            }
        }
        return res;
    }
}
