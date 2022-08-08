package Recursion;

import java.util.ArrayList;

public class SubsequenceSumK {
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int sum=2;
//        printSubsequenceWithSumK(0,new ArrayList<>(),0,sum,arr, arr.length);
//        printOneSubsequenceWithSumK(0,new ArrayList<>(),0,sum,arr, arr.length);
        System.out.println(numSubseq(0,0,sum,arr, arr.length));
    }
    static void printSubsequenceWithSumK(int index, ArrayList<Integer> list, int s, int sum,int[] arr, int n){
        if (index==n){
            if (s==sum){
                for (Integer it: list){
                    System.out.print(it+" ");
                }
                System.out.println();
            }
            return;
        }
        list.add(arr[index]);
        s+=arr[index];
        printSubsequenceWithSumK(index+1,list,s,sum,arr,n);

        s-=arr[index];
        list.remove(list.size()-1);
        printSubsequenceWithSumK(index+1,list,s,sum,arr,n);
    }
    static boolean printOneSubsequenceWithSumK(int index,ArrayList<Integer> list, int s, int sum, int[] arr, int n){
        if (index==n){
            if (s==sum){
                for (Integer it:list){
                    System.out.print(it+" ");
                }
                System.out.println();
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        s+=arr[index];
        if(printOneSubsequenceWithSumK(index+1,list,s,sum,arr,n)){
            return true;
        }
        s-=arr[index];
        list.remove(list.size()-1);
        if (printOneSubsequenceWithSumK(index+1,list,s,sum,arr,n)){
            return true;
        }
        return false;
    }

    static public int numSubseq(int index, int s, int sum, int[] nums, int n) {
        if (s>sum) return 0;
        if (index==n){
            if (s==sum)return 1;
            else return 0;
        }

        s+=nums[index];
        int l=numSubseq(index+1, s, sum, nums, n);
        s-=nums[index];
        int r=numSubseq(index+1, s,sum,nums,n);
        return l+r;
    }

}
