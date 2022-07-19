package Arrays;

import java.util.Arrays;

public class MergeWithoutSpace {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={0,2,6,8,9};
        merge(arr1,arr2,4,5);
        System.out.print(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void merge(int[] arr1, int[] arr2, int n, int m){
        int a=n-1;  //ptr to last number of first arr
        int b=0;    //ptr to first number of second arr
        while (a>=0 && b<m){
            if(arr1[a]>arr2[b]){
                int temp= arr1[a];      //element from last of arr1 is > element from start of arr2
                arr1[a]=arr2[b];
                arr2[b]=temp;
            }
            a--;
            b++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
