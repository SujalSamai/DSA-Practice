package Matrices;
//https://leetcode.com/problems/toeplitz-matrix/
//Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

public class Toeplitz {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
    public static boolean isToeplitzMatrix(int[][] matrix){
        if(matrix==null || matrix.length==0)
            return false;
        for (int i=1;i<matrix.length;i++){
            for (int j=1; j<matrix[0].length;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
