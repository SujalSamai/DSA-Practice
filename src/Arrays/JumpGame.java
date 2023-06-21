package Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr={2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(canJump(arr));
    }
    static boolean canJump(int[] nums){
        int n= nums.length;
        int reachable=0;
        for (int i=0; i<n; i++){
            if(reachable<i){
                return false;
            }
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }
}
