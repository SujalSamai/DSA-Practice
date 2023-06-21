package Matrices;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }

    public static void main(String args[]) {
        int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
