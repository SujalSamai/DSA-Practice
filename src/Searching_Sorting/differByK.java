package Searching_Sorting;

public class differByK {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 7, 6 };
        int x = 6;
        int k = 7;
        int n = arr.length;

        System.out.println("Element " + x + " is present at index " + search(arr, n, x, k));
    }
    /*A Simple Approach is to traverse the given array one by one and compare every element with the given element ‘x’. If matches, then return index.
    The above solution can be Optimized using the fact that the difference between all adjacent elements is at most k.
    The idea is to start comparing from the leftmost element and find the difference between the current array element and x.
    Let this difference be ‘diff’. From the given property of the array, we always know that x must be at least ‘diff/k’ away,
    so instead of searching one by one, we jump ‘diff/k’. */
    static int search(int[] arr, int n, int x, int k){
        int i=0;
        while(i<n){
            if(arr[i]==k){
                return i;
            }
            int steps=Math.abs(arr[i]-x)/k;
            int max=Math.max(1,steps);
            i=i+max;
        }
        return -1;
    }
}
