package DSA_251.Arrays.NonDecreasing;

public class NonDecreasing {
    //Time Complexity - O(n) Space- O(1)
    public static void main(String[] args) {
        int[] arr={-41, -40, -22, -14, -14, -1, 17, 59, -130, 92};
        System.out.println(isPossible(arr, arr.length));
    }
    public static boolean isPossible(int[] arr, int n) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < arr.length && cnt<=1 ; i++){
            if(arr[i-1] > arr[i]){
                cnt++;
                if(i-2<0 || arr[i-2] <= arr[i])arr[i-1] = arr[i];                    //modify nums[i-1] of a priority
                else arr[i] = arr[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }
}
