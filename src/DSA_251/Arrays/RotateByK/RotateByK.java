package DSA_251.Arrays.RotateByK;
import java.util.Scanner;

public class RotateByK {
    //Time Complexity - O(n) Space- O(1)
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        reverse(a, 0, k-1); //reversing till k elements
        reverse(a, k, n-1);     //reversing from k to last elements
        reverse(a, 0, n-1);     //reversing all the elements
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
    }

    static void reverse(int[] arr, int start, int end){
        while (start<end){
            int temp= arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
}
