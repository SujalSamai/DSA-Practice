package Heaps;

import java.util.*;

public class KClosest {
    class Pair{
        int key, value;
        Pair(int diff, int num){
            this.key=diff;
            this.value=num;
        }
    }
    //O(nlog(k))
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        PriorityQueue<Pair> pq= new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                if(p1.key == p2.key){
                    return p2.value - p1.value;
                }
                else{
                    return p2.key - p1.key;
                }
            }
        });
        for (int num: arr) {
            pq.add(new Pair(Math.abs(num-x),num));
            if (pq.size()>k){
                pq.remove();
            }
        }
        List<Integer> res= new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.remove().value);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=3;
        int x=3;
        KClosest kc= new KClosest();
//        System.out.println(kc.findClosestElements(arr,k,x));
        System.out.println(findClosestElements2(arr, k, x));
    }

    //better solution -> Binary Search O(logn)
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int low = 0, high = arr.length -1;

        while(high - low  >= k){
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x))
                low++;
            else
                high--;
        }

        for(int i = low; i <= high; i++)
            result.add(arr[i]);
        return result;
    }
}
