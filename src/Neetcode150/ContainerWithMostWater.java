package Neetcode150;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
    public static int maxArea(int[] height){
        int left =0;
        int right = height.length-1;
        int res =0;
        while (left<right){
            int containerLen = right - left;
//            The key insight here is that moving the longer side inwards is completely unnecessary because the height of
//            the water is bounded by the shorter side.
            int area = containerLen * Math.min(height[left], height[right]); //as only the shorter side matter
            res = Math.max(res, area);

            //shifting only the shorter side and checking if greater area exists
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
