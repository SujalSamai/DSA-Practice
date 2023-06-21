package Recursion;

import java.util.ArrayList;
public class ArrayQuestions {
    public static void main(String[] args) {
        int[] arr={5,6,7,8,1,2,3};
        System.out.println(rSearch(arr,2, 0, arr.length-1 ));
//        ArrayList<Integer> list= new ArrayList<>();
//        System.out.println(findAllIndexes(arr,4,0,list));
    }

    //checks if array is sorted or not
    static boolean sorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sorted(arr, index+1);
    }

    //linear search
    static int eleExists(int[] arr, int target, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return eleExists(arr, target, index+1);
        }
    }

    //if element occurs multiple times, print its indexes in a list
    static ArrayList<Integer> findAllIndexes(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return findAllIndexes(arr, target, index+1,list);
    }

    //rotated Binary Search
    static int rSearch(int[] arr, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(arr[s]<=arr[m]){
            if(target>= arr[s] && target<=arr[e]){
                return rSearch(arr, target, s,m-1);
            }else{
                return rSearch(arr, target, m+1, e);
            }
        }
        if(target>=arr[m] && target<=arr[e]){
            return rSearch(arr,target,m+1, e);
        }else {
            return rSearch(arr, target, s,m-1);
        }
    }
}
