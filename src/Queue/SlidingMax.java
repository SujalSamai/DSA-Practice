package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingMax {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    //naive solution- O(n*k)
    public static int[] maxSlidingWindow1(int[] nums,int k){
        int n=nums.length;
        int j,max;
        int[] res=new int[(n-k)+1];
        for (int i = 0; i <= n-k; i++) {
            max=nums[i];
            for (j= 0; j < k; j++) {
                if(nums[i+j]>max){
                    max=nums[i+j];
                }
            }
            res[i]=max;
        }
        return res;
    }

    //Optimised Solution - Deque - O(n)
    //At each window, remove useless element and add the remaining useful element to the deque
    //useless element-> at each window, if there's an element whose left side has an element less than it
    //for eg-> 1,3,5,1 -> if our window is 3,5,1 then 3 is useless
    public static int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new ArrayDeque<>(); // will store indexes
        int n = nums.length;
        int[] ans = new int[n-k+1];  // will store answers

        int i=0, j=0;
        while (j<n){
            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[j]){
                dq.removeLast();
            }
            dq.addLast(j);
            if(i>dq.peekFirst()){
                dq.removeFirst();
            }
            if(j+1>=k){
                ans[i]=nums[dq.peekFirst()];
                i++;
            }
            j++;
        }
        return ans;
    }

}
