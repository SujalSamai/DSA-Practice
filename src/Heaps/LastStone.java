package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); //max-heap
        int n= stones.length;
        for (int a:stones) {
            pq.add(a);
        }
        int first,second;
        while (n>1){
            //take out the two largest element
            first=pq.peek();
            pq.remove();
            second=pq.peek();
            pq.remove();
            n=n-2;

            //no need to check second>first as it is max-heap, first will always be greater or equal to second
            //if first and second are equal, then don't do anything and continue as they are already removed in above lines
            if(first>second){
                pq.add(first-second);
                n++;
            }
        }
        return (!pq.isEmpty())?pq.peek():0;
    }
}
