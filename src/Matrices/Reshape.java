package Matrices;

import java.util.ArrayList;
import java.util.Arrays;

public class Reshape {
    public static void main(String[] args) {
        int[][] mat={{1,2},{3,4}};
//        deepToString(Object[]) method returns a string representation of the "deep contents" of the specified array.
//        If the array contains other arrays as elements, the string representation contains their contents and so on.
//        This method is designed for converting multidimensional arrays to strings.
        System.out.println(Arrays.deepToString(matrixReshape(mat, 1, 4)));
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c){
        int iniRow=mat.length;
        int iniCol=mat[0].length;
        ArrayList<Integer> list=new ArrayList<>();
        int[][] res=new int[r][c];
        if(iniRow*iniCol!=r*c || (iniRow==r && iniCol==c)){
            return mat;
        }
        for (int i=0; i<iniRow; i++){
            for (int j=0; j<iniCol; j++){
                list.add(mat[i][j]);
            }
        }
        int k=0;
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                res[i][j]= list.get(k);
                k++;
            }
        }
        return res;
    }
}
