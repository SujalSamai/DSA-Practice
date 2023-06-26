package DSA_251.Matrices.SpiralMatrix;

public class SpiralPrint {
    public static void spiralPrint(int matrix[][]){
        if(matrix.length==0) return;

        int row=matrix.length, col=matrix[0].length;
        int i,k=0,l=0;
        while(k<=row && l<=col){
            for(i=l; i<col; i++){
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for(i=k; i<row; i++){
                System.out.print(matrix[i][col-1] + " ");
            }
            col--;
            if(k<row){
                for(i=col-1; i>=l; i--){
                    System.out.print(matrix[row-1][i] + " ");
                }
                row--;
            }
            if(l<col){
                for(i=row-1; i>=k; i--){
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }
}
