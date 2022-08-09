package Recursion;
import java.util.ArrayList;
import java.util.Collections;
//https://practice.geeksforgeeks.org/problems/subset-sums2234/1

public class SubsetSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);
        System.out.println(subsetSums(arr,arr.size()));
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> sumSet=new ArrayList<>();
        recSubset(0,0,arr,N,sumSet);
        Collections.sort(sumSet);
        return sumSet;
    }

    private static void recSubset(int index, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> sumSet) {
        if (index==n){
            sumSet.add(sum);
            return;
        }

        recSubset(index+1,sum+arr.get(index),arr,n,sumSet); //pick
        recSubset(index+1,sum,arr,n,sumSet); //do not pick
    }
}
