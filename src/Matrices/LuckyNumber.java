package Matrices;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static void main(String[] args) {
        int[][] matrix={
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers(int[][] matrix){
        List<Integer> rowMin = new ArrayList<>();
        List<Integer> colMax = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int minRowEl = Integer.MAX_VALUE;
        int maxColEl = Integer.MIN_VALUE;

        for(int i = 0;i<matrix.length;i++)
        {
            for(int j = 0;j<matrix[i].length;j++)
            {
                minRowEl = Math.min(minRowEl,matrix[i][j]);
            }

            rowMin.add(minRowEl);
            minRowEl = Integer.MAX_VALUE;
        }

        for(int i = 0;i<matrix[0].length;i++)
        {
            for(int j = 0;j<matrix.length;j++)
            {
                maxColEl = Math.max(maxColEl,matrix[j][i]);
            }

            colMax.add(maxColEl);
            maxColEl = Integer.MIN_VALUE;
        }

        for(int each:rowMin)
        {
            if(colMax.contains(each))
            {
                result.add(each);
            }
        }

        return result;
    }
}
