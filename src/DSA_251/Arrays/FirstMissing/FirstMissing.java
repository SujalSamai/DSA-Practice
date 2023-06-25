package DSA_251.Arrays.FirstMissing;

public class FirstMissing {
    public static void main(String[] args) {
        int[] arr ={3,2,-6, 1,0};
        System.out.println(firstMissing(arr, arr.length));
    }
    public static int firstMissing(int[] arr, int n) {
        int []check = new int[n];
        int res = n+1;  //if all elements are present in the range then send the next element to that of range
        //for test case {0,1,2,3,4} ans=> 5
        for(int i=0; i<n; i++) {
            if( arr[i] <= n && arr[i] > 0 ) {
                check [arr[i]-1] = -1;
            }
        }

        for(int i=0; i<n; i++){
            if( check[i] != -1 ) {
                res = i+1;
                break;
            }
        }
        return res;
    }
}
