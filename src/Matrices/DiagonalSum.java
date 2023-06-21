package Matrices;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        int size= mat.length;
        int sum=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                if(i==j){
                    sum+=mat[i][j];           //first diagonal sum, always in (i,i) indexed
                }
                if((i+j)==size-1 && i!=j){
                    sum+=mat[i][j];           //second diagonal sum, index always equal to size-1
                }
            }
        }
        return sum;
    }
}
