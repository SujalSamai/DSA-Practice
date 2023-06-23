package DSA_251.TwoPointers;

public class PairSum {

    //Binary Search - O(nlogn) & O(!)
    public static int pairSum(int arr[], int n, int target) {
        int count=0;
        int i=0, j=n-1;
        while (i<j){
            if (arr[i]+arr[j]==target){
                count++;
                i++;
                j--;
            }else if(arr[i]+arr[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return count==0 ? -1 : count;
    }
}
