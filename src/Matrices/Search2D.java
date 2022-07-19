package Matrices;
//Write an efficient algorithm that searches for a value target in an m x n integer matrix. This matrix has the following properties:
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
public class Search2D {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        int row=0;
        int col=matrix[0].length-1;
        while (row<matrix.length && col>=0){  //started checking from (0,last number of first row)
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){  //if last number is less than target, then the number is not present in that row
                row++;
                continue;
            }
            if(matrix[row][col]>target){  //if last number is greater than target, then the number is present, check in the previous columns
                col--;
            }
        }
        return false;
    }
}
