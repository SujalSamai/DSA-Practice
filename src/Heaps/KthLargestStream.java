package Heaps;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
import java.util.PriorityQueue;

public class KthLargestStream {
    private int k;
    private PriorityQueue<Integer> pq=new PriorityQueue<>(); //priority queue in java is by default min heap priority queue
    public KthLargestStream(int k, int[] nums) {
        this.k=k;
        for (int a:nums) {
            pq.add(a);
        }
    }
    //approach-> suppose we have min heap [4,5,8,2] and k=3, now in this arr 2 is of no use, as it can never be third largest
    //so we remove the smallest element from the heap, so remaining elements will always be k elements in the heap which are the largest ones
    //now if we do pq.peek it will return the smallest element among the heap elements as it is min heap
    //and this smallest element is already the kth largest, as we have only included the 'k' largest ones in the heap
    //adding takes O(logN) and finding minimum takes O(1)-> overall O(logN)
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.remove(); //remove the values from the pq and it'll remove minimum values first
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestStream kthLargest = new KthLargestStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));
    }
}
