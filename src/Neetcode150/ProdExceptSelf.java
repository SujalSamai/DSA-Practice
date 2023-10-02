package Neetcode150;

import java.util.Arrays;

public class ProdExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(productExceptSelf(nums));
    }

    /*
    - Similar to finding Prefix Sum Array, here we would intend to find the Prefix Product Array and Suffix Product Array for our original array, i.e. pre[i] = pre[i - 1] * a[i - 1] (yes, we multiply with a[i - 1] and not with a[i] on purpose) and similarly suff[i] = suff[i + 1] * a[i + 1].
    - Now, at any index i our final answer ans[i] would be given by ans[i] = pre[i] * suff[i]. Why?
    - Because the pre[i] * suff[i] contains product of every element before i and every element after i but not the element at index i (and that is the reson why we excluded a[i] in our prefix and suffix product).
    - The Time Complexity would be O(n), but we are now using Auxilary Space of O(n) (excluding the final answer array).
   - But we don't actually need seperate array to store prefix product and suffix products, we can do all the approach discussed directly onto our final answer array.
   - The Time Complexity would be O(n) but now, the Auxilary Space is O(1) (excluding the final answer array).
   */

    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
