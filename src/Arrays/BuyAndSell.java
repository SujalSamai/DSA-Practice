package Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
public class BuyAndSell {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int max=0;
        int cur=prices[0];
        for (int x:prices){
            if(cur>x){
                cur=x;  //this holds the lowest value in the array
            }else {
                int profit=x-cur;   //calculates profit whenever price is greater than the lowest value
                if(profit>max){
                    max=profit;   //gets the maximum profit
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices){
        int maxProfit=0;
        int mini=prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur=prices[i]-mini;
            maxProfit=Math.max(maxProfit,cur);
            mini=Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
}
