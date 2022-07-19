package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    //just find next greatest element's index and subtract it with the index of current element
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> s=new Stack<>();
        int n= temperatures.length;
        int[] res=new int[n];
        for (int i=n-1; i>=0; i--){
            while (!s.isEmpty() && temperatures[i]>=temperatures[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i]=0;
            }else {
                res[i]=s.peek()-i;
            }
            s.push(i);
        }
        return res;
    }
}
