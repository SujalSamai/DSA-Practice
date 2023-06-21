package Recursion;

public class ReduceToZero {
    public static void main(String[] args) {
        int n=71;
        System.out.println(numberOfSteps(n));
    }
    public static int numberOfSteps(int num){
        return countSteps(num,0);
    }
    public static int countSteps(int num,int count){
        if(num==0){
            return count;
        }
        if(num%2==0){
            count++;
            return countSteps(num/2, count);
        }
        else{
            count++;
            return countSteps(num- 1, count);
        }
    }
}
