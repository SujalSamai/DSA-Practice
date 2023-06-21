package Stacks;
//https://leetcode.com/problems/next-greater-element-i/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreatest {
    public static void main(String[] args) {
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElements(nums1,nums2)));
    }
    public static int[] nextGreaterElements(int[] nums1,int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        int[] res = new int[nums1.length];

        //normal solution of next greatest
        for(int i = nums2.length - 1; i >= 0; i --) {
            //if number in stack is less than the nums element pop it out
            while(!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            //if stack becomes empty return -1
            if(s.empty()){
                map.put(nums2[i],-1);
            }
            //if stack is not empty and stack top is greater than nums element, add to answer
            else{
                map.put(nums2[i],s.peek());
            }
            //push the current number back to the stack
            s.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i]=map.get(nums1[i]);
        }

        return res;
    }
}
