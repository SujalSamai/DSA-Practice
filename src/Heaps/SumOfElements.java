package Heaps;
//https://www.geeksforgeeks.org/sum-elements-k1th-k2th-smallest-elements/

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElements {
    public static void main(String[] args) {
        int[] arr={20, 8, 22, 4, 12, 10, 14 };
        int k1=3;
        int k2=6;
        int n=arr.length;
        System.out.println(sumBetweenTwoKth(arr,n,k1,k2));
    }
    public static int kthSmallest(int[] arr, int n, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        for (int num: arr) {
            pq.add(num);
            while (pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static int sumBetweenTwoKth(int[] arr,int n,int k1, int k2){
        int first=kthSmallest(arr,n,k1);
        int second=kthSmallest(arr,n,k2);

        int sum=0;
        for (int num:arr){
            if(num>first && num<second){
                sum+=num;
            }
        }
        return sum;
    }
}
