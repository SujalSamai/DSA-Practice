package DSA_251.Arrays.MajorityElement2;

import java.util.ArrayList;

public class MajorityElem2 {
    //The key idea behind this algorithm is that in an array of size n,
    // there can be at most two elements that appear more than ⌊ n/3 ⌋ times
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        ArrayList<Integer> res= new ArrayList<>();
        if(arr.size()==0) return res;

        int num1=-1, num2=-1;
        int count1=0, count2=0;

        for (Integer val:arr) {
            if(val == num1) count1++;
            else if(val == num2) count2++;
            else if(count1==0){
                num1=val;
                count1=1;
            }else if(count2==0){
                num2=val;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }

        //checking if the numbers are in majority or not
        count1 = 0;
        count2 = 0;
        for(Integer val : arr) {
            if(val == num1)
                count1++;
            else if(val == num2)
                count2++;
        }
        if(count1 > arr.size()/3)
            res.add(num1);
        if(count2 > arr.size()/3)
            res.add(num2);
        return res;
    }
}
