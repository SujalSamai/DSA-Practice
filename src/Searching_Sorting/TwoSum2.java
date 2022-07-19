package Searching_Sorting;

import java.util.Arrays;

/*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.*/
public class TwoSum2 {
    public static void main(String[] args) {
        int[] num={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(num,target)));
    }
    public static int[] twoSum(int[] numbers, int target){
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else {
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }




}
