package Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
public class CandyDistribution {
    public static void main(String[] args) {
        int[] arr={1,2,87,87,87,2,1};
        System.out.println(candy(arr));
    }
    public static int candy(int[] ratings) {
        int n= ratings.length;
        int[] left=new int[n];
        Arrays.fill(left,1);
        int[] right=new int[n];
        Arrays.fill(right,1);
        for (int i = 1; i < n; i++) {
            if (ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for (int i = n-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            left[i]=Math.max(left[i],right[i]);
            count+=left[i];
        }
        return count;
    }
}
