package Stacks;

import java.util.Stack;

public class RainwaterTrapping {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
//        System.out.println(maxWaterTrapped(height));
    }

    //Basic Idea of the solution: Create an array which will store the amount of water that can be stored at each index
    //To find amount of water that can be stored at each index do this:
    //Find the greatest to the left and greatest to the right of index. And take the minimum of them
    //Now subtract the min and current element at the index. Store the result in the new array
    //Simply return the sum of all elements of resultant arr

    //Optimal Array Approach
    static public int trap(int[] arr) {
        int n= arr.length;
        int total = 0;
        int high1 = 0, high2 = 0;
        int l = 0, r = n-1;
        while(l<r)
        {
            if (arr[l] < arr[r]) {
                high1 = Math.max(high1, arr[l]);
                total += high1 - arr[l];
                l++;
            } else {
                high2 = Math.max(high2, arr[r]);
                total += high2 - arr[r];
                r--;
            }
        }
        return total;
    }

    //Stack Approach
    static int maxWaterTrapped(int[] height) {
        int maxWater = 0, current = 0;
        int size= height.length;
        Stack<Integer> st=new Stack<>();
        while (current < size) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                maxWater += distance * bounded_height;
            }
            st.push(current);
            current = current + 1;
        }
        return maxWater;
    }
    //read this:
    //https://leetcode.com/problems/trapping-rain-water/discuss/2254990/Variation-of-next-greater-element-with-visual-approach-java-code-and-Explanation-O(n)-time
}
