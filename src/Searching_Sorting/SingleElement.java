package Searching_Sorting;

public class SingleElement {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
//        int el=nums[0];
//        for (int i=1;i<nums.length;i++){
//            el^=nums[i];
//        }
//        return el;

        if (nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == nums.length - 1 || mid == 0)
                return nums[mid];
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            else if (nums[mid] == nums[mid + 1]) {
                mid = mid + 1;
            }
            if ((mid - low) % 2 != 0)
                low = mid + 1;
            else {
                high = mid - 2;
            }
        }
        return -1;
    }
}
