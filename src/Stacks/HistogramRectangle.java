package Stacks;

import java.util.Stack;

public class HistogramRectangle {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    //based on previous smaller and next smaller combined principle
    public static int largestRectangleArea(int[] heights) {
        //take two arrays, one will store previous smaller element's index and other will store next smaller element's index
        int maxAns=Integer.MIN_VALUE;
        int n= heights.length;
        int[] ps= prevSmaller(heights);
        int[] ns= nextSmaller(heights);
        for (int i = 0; i < n; i++) {
            int cur=(ns[i]-ps[i]-1)* heights[i];
            maxAns=Math.max(maxAns,cur);
        }
        return maxAns;
    }

    private static int[] nextSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] ns = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            if(st.isEmpty()){
                ns[i] = heights.length;
            }
            else{
                ns[i] = st.peek();
            }
            st.push(i);
        }
        return ns;
    }

    private static int[] prevSmaller(int[] heights){
        int[] ps=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i]=-1;
            }else{
                ps[i]=s.peek();
            }
            s.push(i);
        }
        return ps;
    }
}
