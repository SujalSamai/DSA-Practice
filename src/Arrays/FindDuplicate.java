package Arrays;

import java.util.HashSet;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        System.out.println(find(arr));
    }

    static int find(int[] nums){
        HashSet<Integer> set= new HashSet<>();
        for (int i: nums){
            if(set.contains(i)){
                return i; //if the number is already present in the set, return it
            }
            set.add(i);  //if number is not present in set, add it into set
        }
        return -1;
    }
}
