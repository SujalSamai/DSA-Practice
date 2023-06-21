package Arrays;
//https://leetcode.com/problems/intersection-of-two-arrays/
//Given two integer arrays nums1 and nums2, return an array of their intersection and union.
// Each element in the result must be unique and you may return the result in any order.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
        System.out.println(Arrays.toString(union(nums1,nums2)));
    }

    static int[] intersection(int[] nums1,int[] nums2){
        HashSet<Integer> set= new HashSet<>();  //so that we get distinct elements
        ArrayList<Integer> list= new ArrayList<>(); //as we don't know what will be the size of array
        for (int i:nums1){
            set.add(i);
        }

        for (int j:nums2){
            if(set.contains(j)){
                list.add(j);  //if set already contains the number, then we add to list as it is intersected el
                set.remove(j);  //removing it from the set so that it doesn't get checked again
            }
        }

        int[] arr= new int[list.size()]; //converting to array

        for (int i=0; i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }

    static int[] union(int[] nums1, int[] nums2){
        HashSet<Integer> set= new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int j:nums2){
            set.add(j);
        }
        int[] arr= new int[set.size()];
        int i=0;
        for (int el:set){
            arr[i++]=el;
        }
        return arr;
    }
}
