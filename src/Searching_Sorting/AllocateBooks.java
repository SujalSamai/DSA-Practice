package Searching_Sorting;
//https://www.interviewbit.com/problems/allocate-books/
public class AllocateBooks {
    public int books(int[] A, int B) {
        if (B>A.length) return -1;
        int low=A[0];
        int high=0;
        for (int i = 0; i < A.length; i++) {
            high=high+A[i];
            low=Math.min(low, A[i]);
        }
        int res=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (isPossible(A,mid,B)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] A, int pages, int students) {
        int cnt=0;
        int sum=0;
        for (int i = 0; i < A.length; i++) {
            if (sum+A[i]>pages){
                cnt++;
                sum=A[i];
                if (sum>pages)return false;
            }else{
                sum+=A[i];
            }
        }
        if (cnt<students)return true;
        return false;
    }
}
