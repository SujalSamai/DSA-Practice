package DSA_251.Matrices;

public class ReverseMatrix {
    public static void main(String[] args) {
        int[][] mat={
                {1,2,3},
                {2,4,5},
                {3,5,8},
        };

    }

    //When you transpose a matrix mat[i][j] becomes mat[j][i]
    //Time complexity- O(N^2) & Space Complexity- O(1)
    public static boolean isMatrixSymmetric(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                int value = matrix[i][j];
                if(matrix[j][i] != value){
                    return false;
                }
            }
        }
        return true;
    }
}
