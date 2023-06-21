package Maths;
//https://www.interviewbit.com/problems/rearrange-array/
//Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
import java.util.ArrayList;

public class RearrangeArr {
    public static void main(String[] args) {
        ArrayList<Integer> a= new ArrayList<>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);
        arrange(a);
    }
    public static void arrange(ArrayList<Integer> a) {
        //Accepted Solution
        int n= a.size();
        int[] arr= new int[n];
        for(int i=0;i<n; i++){
            arr[i]= a.get(a.get(i));
        }
        for(int i=0; i<n; i++){
            a.set(i,arr[i]);
        }
        System.out.println(a);
    }
}
