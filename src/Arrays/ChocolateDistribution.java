package Arrays;
//https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
//Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
// Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets
// among M students such that :
//1. Each student gets exactly one packet.
//2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {
    public static void main(String[] args) {
        ArrayList<Long> arr=new ArrayList<Long>(){
            {
                add(3L);
                add(4L);
                add(1L);
                add(9L);
                add(56L);
                add(7L);
                add(9L);
                add(12L);
            }
        };
        int m=5;
        System.out.println(findMinDiff(arr,arr.size(),m));
    }
    public static long findMinDiff(ArrayList<Long> a, long n, long m){
        Collections.sort(a);
        //The intuition is that, in order to minimize the diff between max number of chocolates given and min number of chocolates given to student
        //we need to choose packets which are closer in value, so we sort the arr
        //for eg. 56-1=55, but 9-1=8

        long min=Integer.MAX_VALUE;
        for (int i=0;i<=n-m;i++){
//            long maxWindow=a.get((int) (i+m-1));
//            long minWindow=a.get(i);
            long gap=a.get((int) (i+m-1))-a.get(i);
            if(gap<min){
                min=gap;
            }
        }
        return min;
    }
}
