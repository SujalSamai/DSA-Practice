package Arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
//Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.
public class TripletSum {
    public static void main(String[] args) {
        int[] A={3,2,6,8,1};
        int target=11;
        System.out.println(find3numbers(A,A.length,target));
    }
    static boolean find3numbers(int[] A,int n, int X){
        Arrays.sort(A);
        for (int i=0; i<n;i++){
            int low=i+1;
            int high=n-1;
            while (low<high){
                int sol=A[i]+A[low]+A[high];
                if(sol==X){
                    return true;
                }else if(sol<X){
                    low++;
                }else {
                    high--;
                }
            }
        }
        return false;
    }
}
