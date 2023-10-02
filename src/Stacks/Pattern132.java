package Stacks;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] arr= {1,0,1,-4,-3};
        System.out.println(find132pattern(arr));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
