package Stacks;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'0','1','1','1','1','0'},
                {'1','1','1','1','0','1'},
                {'1','1','0','1','1','1'},
                {'1','1','1','1','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    //variation of Histogram Area Question
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxRect = 0;

        //this array will have the heights of rectangle in a column
        int[] arr = new int[n];
        //traverse each row
        for(int i =0; i<m; i++){
            //copy each row in the array and find the largest rectangle area using Histogram method
            //through this way of copying we will ensure that whenever we find 0 in any row, we will just keep it 0
            //but if we find 1, we will add it to the previous row's element in the same index
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1;
                }else{
                    arr[j] = 0;
                }
            }
            int currAns = largestRectangleArea(arr);
            maxRect = Math.max(maxRect, currAns);
        }
        return maxRect;
    }
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
