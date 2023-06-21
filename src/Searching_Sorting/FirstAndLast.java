package Searching_Sorting;
//Given a sorted array arr containing n elements with possibly duplicate elements,
// the task is to find indexes of first and last occurrences of an element x in the given array.
import java.util.ArrayList;

public class FirstAndLast {
    public static void main(String[] args) {
        long[] arr={ 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int x=5;
        System.out.println(find(arr,arr.length,x));

    }
    static ArrayList<Long> find(long[] arr, int n, int x){
        ArrayList<Long> list= new ArrayList<>();
        long index1=-1, index2=-1;
        int s=0;
        int e=n-1;
        //for first index
        while (s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==x){
                index1=m;   //we found x but it may not be the first one so we check at left side
                e=m-1;  //this line is to make sure that we get the index of first occurrence only
            }
            else if(arr[m]>x){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        //for second index
        s=0;
        e=n-1;
        while (s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==x){
                index2=m;   //we found x but it may not be the last one so check at right side
                s=m+1;  //this line is to make sure that we get the index of last occurence only
            }
            else if(arr[m]>x){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        list.add(index1);
        list.add(index2);
        return list;
    }

}
