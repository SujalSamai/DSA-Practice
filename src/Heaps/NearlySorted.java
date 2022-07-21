package Heaps;
//https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
    }
    public static void kSort(int[] arr, int n, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> list= new ArrayList<>();
        if(n==k){
            k=k-1;
        }
        for (int num:arr) {
            pq.add(num);
            if(pq.size()>k){
                list.add(pq.poll());
            }
        }
        while (pq.size()>0){
            list.add(pq.poll());
        }
        System.out.println(list);
    }
}
