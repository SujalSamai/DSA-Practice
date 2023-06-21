package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    class Pair{
        int key, value;
        Pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int n:nums) {
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
                map.put(n,map.get(n)+1);
            }
        }
        // comparator for sorting in decreasing order from a key val pair
        //Creating max heap
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.key-o1.key;
            }
        });

        //Adding the map key value pairs in the custom made Pair in heap.
        //As we want to sort according to the values, we are adding values first
        map.forEach((key,val)->{
            pq.add(new Pair(val,key));
        });

        //Keys having highest value will be at top as it is a Max Heap
        //Take the first k elements from top and add into array
        int [] arr=new int[k];
        for (int i = 0; i < k; i++) {
            arr[i]=pq.remove().value;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,3,2,2,4};
        int k=2;
        TopKFrequent fr=new TopKFrequent();
        System.out.println(Arrays.toString(fr.topKFrequent(arr,k)));
    }
}
