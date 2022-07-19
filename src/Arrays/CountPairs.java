package Arrays;

import java.util.HashMap;

public class CountPairs {
    public static void main(String[] args) {
        int[] arr={1,5,7,1};
        System.out.println(getPairsCount(arr,arr.length,6));
    }
    public static int getPairsCount(int[] arr, int n, int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int count=0;
        for (int x:arr){
            if(hm.containsKey(k-x)){  //containsKey checks if this key is present in HashMap
                count+=hm.get(k-x);       //get returns the object that contains the value associated with the key.
            }
            hm.put(x,hm.getOrDefault(x,0)+1);
            //Hash_Map.put(key, value)
            //gives value of x to be 0+1 =>1 initially and from next time, gets value as 1 for x and updates it to 1+1=>2
        }
        return count;
    }
}
