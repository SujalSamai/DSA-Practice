package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargest {
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-(k)];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int n:nums) {
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
