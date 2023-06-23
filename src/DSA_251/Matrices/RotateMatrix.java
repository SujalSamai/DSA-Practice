package DSA_251.Matrices;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        inplaceRotate(arr,arr.length);
        System.out.println(Arrays.deepToString(arr));
    }
    public static void inplaceRotate(int[][] arr, int n) {
        //transpose the matrix
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse the matrix
        int start=0, end=n-1;
        while (start<=end){
            int[] temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
