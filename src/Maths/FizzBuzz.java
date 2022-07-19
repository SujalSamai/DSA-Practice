package Maths;
//https://www.interviewbit.com/problems/fizzbuzz/
//Given a positive integer A, return an array of strings with all the integers from 1 to N.
//But for multiples of 3 the array should have “Fizz” instead of the number.
//For the multiples of 5, the array should have “Buzz” instead of the number.
//For numbers which are multiple of 3 and 5 both, the array should have “FizzBuzz” instead of the number.
import java.util.Arrays;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzbuzz(5)));
    }

    public static String[] fizzbuzz(int A){
        String[] arr= new String[A];
        for (int i=0; i<A; i++){
            if((i+1)%3==0 && (i+1)%5==0){
                arr[i]="FizzBuzz";
            }
            else if((i+1)%3==0){
                arr[i]="Fizz";
            }
            else if((i+1)%5==0){
                arr[i]="Buzz";
            }
            else{
                arr[i]=i+1+"";
            }

        }
        return arr;
    }
}
