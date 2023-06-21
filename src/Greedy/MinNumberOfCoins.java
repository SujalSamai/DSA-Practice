package Greedy;
//https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoins {
    public static void main(String[] args) {
        int N=49;
        System.out.println(minPartition(N));
    }
    static List<Integer> minPartition(int N) {
        List<Integer> ans=new ArrayList<>();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = coins.length;
        for (int i = n-1; i >= 0; i--) {
            while (N>=coins[i]){
                N-=coins[i];
                ans.add(coins[i]);
            }
        }
        return ans;
    }
}
