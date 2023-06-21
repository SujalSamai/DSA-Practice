package Arrays;
//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
//Difficulty Level: Easy
//Write a function to return minimum and maximum in an array. Your program should make the minimum number of comparisons.
public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr={45,64,56,78,12,0,21};
        maxMinEl(arr);
    }
    public static void maxMinEl(int[] arr){
        int n= arr.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0; i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
    }
}
