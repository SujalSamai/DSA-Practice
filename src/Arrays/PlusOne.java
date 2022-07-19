package Arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    //Note: the solution works for any number for carry
    public static int[] plusOne(int[] digits){
        int carry = 1;  // you can replace carry with any number you want to add.
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if(digits[i] > 9) {
                carry = digits[i] / 10;  //will convert 10 to 1
                digits[i] = digits[i] % 10;  //and the array will contain 0 from 10 and store it through this
            }
            else {
                carry = 0;
                break;
            }
        }
        if(carry == 0) {
            return digits;
        }
        else {  //will come handy when digits is like this-> 9,9,9,9    result will become 0,0,0,0 from above code
                //to make it 1,0,0,0,0 we will create a new array of length+1
            int[] arr = new int[digits.length + 1];
            arr[0] = carry;  //first index will be equal to 1 here and rest all are by default 0
//            for(int i = 0; i < digits.length; i++) {  //useful when carry>1
//                arr[i + 1] = digits[i];
//            }
            return arr;
        }
    }
}
