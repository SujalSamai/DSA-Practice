package Recursion;
//https://www.geeksforgeeks.org/sum-triangle-from-array/
//Given an array of integers, print a sum triangle from it such that the first level has all array elements.
// From then, at each level number of elements is one less than the previous level and elements at the level is be the
// Sum of consecutive two elements in the previous level.
import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        printTriangle(A);
    }

    public static void printTriangle(int[] a){
        if(a.length<1){  //base case
            return;
        }
        int[] temp= new int[a.length-1];
        for (int i=0; i<a.length-1; i++){
            int sum= a[i]+a[i+1];  //sum of two consecutive numbers of array
            temp[i]=sum;
        }

        printTriangle(temp);
        System.out.println(Arrays.toString(a));  //this is the last statement so that print happens in bottom up approach

    }
}
