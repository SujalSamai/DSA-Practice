package Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int left=0;
        int right= height.length-1;
        int res=0;
        while(left<right){
            int containerLength=right-left;
            int area= containerLength * Math.min(height[right], height[left]);
            res=Math.max(res, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
