package Matrices;

import java.util.HashMap;

public class CommonEl {
    public static void main(String[] args) {
        int[][] arr={{1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };
        printCommonElements(arr);
    }
    public static void printCommonElements(int[][] mat){
        int row= mat.length;
        int col=mat[0].length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i=0;i<col;i++){
            //Initialises all the elements present in 1st row to have 1 occurrence
            map.put(mat[0][i],1);
        }

        for (int i=1;i<row;i++){    //starting from 1 as first row is already initialised
            for (int j=0; j<col;j++){
                //if the key is already present and its value is equal to row number(to avoid duplicate items in a single row)
                //equal to row number as till that row, if value is equal to row number that means it has occur once in every row
                if(map.containsKey(mat[i][j]) && map.get(mat[i][j])==i){
                    map.put(mat[i][j],map.get(mat[i][j])+1);
                }
                //When the outer loop has reached the last row and map is not empty and
                // the value of the keys is equal to row value(common values will have value equal to row number)
                if(i==row-1 && map.containsKey(mat[i][j]) && map.get(mat[i][j])==row){
                    System.out.print(mat[i][j]+" ");
                }
            }
        }
    }
}
