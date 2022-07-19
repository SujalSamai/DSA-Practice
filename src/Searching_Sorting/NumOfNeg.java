package Searching_Sorting;

public class NumOfNeg {
    public static void main(String[] args) {
        int[][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
    //row is in decreasing order and col is also in decreasing order
    //at every row, if we find an element which is negative, then the elements after that will also be negative in that row
    //start from bottom
    public static int countNegatives(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int row=m-1;
        int col=0;
        int count=0;
        while (row>=0 && col<n){
            if(grid[row][col]<0){
                count= count+ (n-col);
                //n-col=> total columns- col at which we are standing=> gives total columns which are less than grid[row][col]
                row--;
            }
            else{
                col++;
            }
        }
        return count;
    }
}
