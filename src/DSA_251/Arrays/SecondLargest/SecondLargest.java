package DSA_251.Arrays.SecondLargest;


public class SecondLargest {
    //Time Complexity - O(n) Space- O(1)
    public static int findSecondLargest(int n, int[] arr) {
        int maxi=Integer.MIN_VALUE;
        int secondMax= Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i]>maxi){
                secondMax= maxi;
                maxi=arr[i];
            }else if(arr[i]>secondMax && arr[i]!= maxi){
                secondMax= arr[i];
            }
        }
        if(secondMax == Integer.MIN_VALUE) return -1;
        else return secondMax;
    }
}

