package DP;
//https://leetcode.com/problems/maximal-rectangle/
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        int[] heights= new int[m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]=='1') heights[j]++;
                else heights[j]='0';
            }
            int area=largestRectangleArea(heights);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxA=0;
        int n=heights.length;
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>heights[i])){
                int h=heights[st.peek()];
                st.pop();
                int width=0;
                if(st.isEmpty()) width=i;
                else{
                    width= i- st.peek() -1;
                }
                maxA= Math.max(maxA,width*h);
            }
            st.push(i);
        }
        return maxA;
    }
}
