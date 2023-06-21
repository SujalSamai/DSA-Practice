package Bitwise;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={1,2,3,2,1,4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int res=nums[0];
        for (int i=1; i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }
//    public static int[] singleNumber2(int[] nums) {
//        int res=nums[0];
//        for (int i=1; i<nums.length;i++){
//            res^=nums[i];
//        }
//        res = res & (-res);
//        int sum1 = 0;
//        int sum2 = 0;
//        for(int i=0;i<nums.length;i++){
//            if((nums[i]&res)>0){
//                sum1 = sum1^nums[i];
//            }
//            else{
//                sum2 = sum2^nums[i];
//            }
//        }
//        int[] ans = new int[2];
//
//        if(sum1<sum2){
//            ans[0] = sum1;
//            ans[1] = sum2;
//        }
//        else{
//            ans[0] = sum2;
//            ans[1] = sum1;
//        }
//        return ans;
//    }

}
