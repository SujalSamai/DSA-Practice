package Maths;
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class MissingNumber {
    public static void main(String[] args) {
        int[] num={3,0,1};
        System.out.println(missing(num));
    }
    //sum of n numbers
    public static int missing(int[] nums){
        int len=nums.length; //this is the n in the range[0,n]
        int actual_sum=(len*(len+1))/2;
        int given_sum=0;
        for (int i=0; i<nums.length;i++){
            given_sum+=nums[i];
        }
        return actual_sum-given_sum;
    }
}
