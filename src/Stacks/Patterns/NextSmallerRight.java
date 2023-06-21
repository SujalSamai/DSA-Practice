package Stacks.Patterns;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerRight {
    public static void main(String[] args) {
        int[] nums={4,5,2,10,8};
        System.out.println(Arrays.toString(nextSmallerElementsRight(nums)));
    }
    public static int[] nextSmallerElementsRight(int[] nums){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];

        //move from right to left
        for(int i = nums.length - 1; i >= 0; i --) {
            //if number in stack is less than the nums element pop it out
            while(!s.isEmpty() && s.peek() >= nums[i]) {
                s.pop();
            }
            //if stack becomes empty return -1
            if(s.empty()){
                res[i]=-1;
            }
            //if stack is not empty and stack top is less than nums element,
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
