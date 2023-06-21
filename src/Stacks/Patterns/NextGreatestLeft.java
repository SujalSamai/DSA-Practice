package Stacks.Patterns;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestLeft {
    public static void main(String[] args) {
        int[] nums={1,3,2,4};
        System.out.println(Arrays.toString(nextGreaterElementsLeft(nums)));
    }
    public static int[] nextGreaterElementsLeft(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];

        //move from left to right
        for(int i=0;i< nums.length; i++) {
            //if number in stack is less than the nums element pop it out
            while(!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            //if stack becomes empty return -1
            if(s.empty()){
                res[i]=-1;
            }
            //if stack is not empty and stack top is greater than nums element,
            //add to answer
            else{
                res[i]=s.peek();
            }
            //push the current number back to the stack
            s.push(nums[i]);
        }
        return res;
    }
}
