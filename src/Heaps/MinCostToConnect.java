package Heaps;
//https://leetcode.com/problems/minimum-cost-to-connect-sticks ->premium question
//https://wentao-shao.gitbook.io/leetcode/data-structure/1167.minimum-cost-to-connect-sticks -> refer from here
//Given n ropes of different lengths, we need to connect these ropes into one rope.
// We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths.
// The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes
// are connected into a single rope. Find the min possible cost required to connect all ropes.

import java.util.PriorityQueue;

public class MinCostToConnect {
    public static void main(String[] args) {
        int[] sticks = {1,8,3,5};
        System.out.println(connectSticks(sticks));
    }

    //the idea is to use the max Elements as less as possible to reduce the total cost
    //we should always take the two min elements and add them to make new sticks, only that way the cost will be minimum
    //Important: Use Min Heap, Time Complexity-> O(NlogN)
    public static int connectSticks(int[] sticks){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int s :sticks) {
            pq.add(s);
        }

        int finalAns=0;
        while (pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            int sum=first+second;
            finalAns+=sum;
            pq.add(sum);
        }
        return finalAns;
    }
}
