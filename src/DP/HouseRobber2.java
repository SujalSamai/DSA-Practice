package DP;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int[] arr1=new int[nums.length-1];
        int[] arr2=new int[nums.length-1];

        if (nums.length==1) return nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i!=0) arr1[i-1]=nums[i];
            if (i!=nums.length-1) arr2[i]=nums[i];
        }

        int ans1=solve(arr1);
        int ans2=solve(arr2);

        return Math.max(ans1,ans2);
    }

    private static int solve(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for (int i = 1; i < nums.length ; i++) {
            int pick=nums[i];
            if (i>1){
                pick+=prev2;
            }
            int notPick=prev;

            int curi=Math.max(pick,notPick);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}
