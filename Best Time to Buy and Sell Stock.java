/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int date = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < prices[date]) date = i;
            int temp = prices[i] - prices[date];
            max = Math.max(max, temp);
        }
        return max;
    }
}