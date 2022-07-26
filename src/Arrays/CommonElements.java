package Arrays;
//https://practice.geeksforgeeks.org/problems/common-elements1132/1
//Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
import java.util.ArrayList;

public class CommonElements {
    public static void main(String[] args) {
        int[] arr1={1, 5, 10, 20, 40, 80};
        int[] arr2={6, 7, 20, 80, 100};
        int[] arr3={3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(arr1,arr2,arr3,6,5,8));
    }

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3){
        ArrayList<Integer> list=new ArrayList<>();
        int i=0,j=0,k=0;
        while (i<n1 && j<n2 && k<n3){
            if(A[i]==B[j] && B[j]==C[k]){
                if(!list.contains(A[i])){  //add A[i] only if it's not present already
                    list.add(A[i]);
                }
                i++;j++;k++;
            }
            else if(A[i]<B[j]){     //as array is sorted
                i++;
            }else if(B[j]<C[k]){
                j++;
            }else{
                k++;
            }
        }
        return list;
    }
}
