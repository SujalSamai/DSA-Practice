package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {
    class Pair{
        int key, value;
        Pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public int[] frequencySort(int[] nums) {
        //Create a map containing the number and its frequency
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int num:nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        //Create a max heap in which if keys are same, we check big value else big key
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.key == p2.key){
                    return p2.value - p1.value;
                }else{
                    return p1.key - p2.key;
                }
            }
        });

        //Add the map elements into the custom pair, but the key will be frequency and value will be the number
        map.forEach((key,value)->{
            pq.add(new Pair(value,key));
        });

        int[] res=new int[nums.length];
        int j=0;
        //add the numbers according to their frequency in the arr
        while (!pq.isEmpty()){
            int freq= pq.peek().key;
            int el=pq.peek().value;
            while (freq>0){
                res[j++]=el;
                freq--;
            }
            pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,3};
        FrequencySort s=new FrequencySort();
        System.out.println(Arrays.toString(s.frequencySort(arr)));
    }
}
