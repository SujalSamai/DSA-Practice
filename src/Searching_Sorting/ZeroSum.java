package Searching_Sorting;

import java.util.HashMap;
/*https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.*/
public class ZeroSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        System.out.println(subarraySum(arr,2));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                count++;
            }
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            int val=(int)map.getOrDefault(sum,0)+1;
            map.put(sum,val);
        }
        return count;
    }
}
