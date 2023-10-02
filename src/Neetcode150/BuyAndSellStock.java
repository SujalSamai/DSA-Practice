package Neetcode150;

public class BuyAndSellStock {
    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int mini = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cur);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
