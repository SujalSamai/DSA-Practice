package Searching_Sorting;
//Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFourSum {
    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
        int k=0;
        System.out.println(fourSum(arr,k));
    }
    public static List<List<Integer>> fourSum(int[] arr, int k){
        Arrays.sort(arr);
        ArrayList<List<Integer>> list=new ArrayList<>();
        int n=arr.length;
        if(arr==null || n==0){
            return list;
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int target=k-(arr[i]+arr[j]);
                int left=j+1;
                int right=n-1;
                while (left<right){
                    int remSum=arr[left]+arr[right];
                    //as array is sorted
                    if(remSum<target) left++;
                    else if(remSum>target) right--;
                    else {
                        List<Integer> quad=new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);

                        //adding to the final list
                        list.add(quad);

                        //skipping the duplicates of the third number
                        while (left<right && arr[left]==quad.get(2)){
                            ++left;
                        }
                        //skipping the duplicates of the fourth number
                        while (left<right && arr[right]==quad.get(3)){
                            --right;
                        }
                    }
                    //skipping the duplicates of the second number
                    //we are stopping the skip 1 stop back as the for loop will automatically update it to next element
                    while (j+1<n && arr[j+1]==arr[j]){
                        ++j;
                    }
                }
                //skipping the duplicates of the first number
                //we are stopping the skip 1 stop back as the for loop will automatically update it to next element
                while (i+1<n && arr[i+1]==arr[i]) {
                    ++i;
                }
            }
        }
        return list;
    }
}
