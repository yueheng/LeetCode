/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int max = 0;
        int minF = prices[0]; //min forward
        int maxB = prices[n-1]; // max backward
        int[] fA = new int[n];  // forward array
        int[] bA = new int[n];  // backward array
        fA[0] = 0;
        bA[n-1] = 0;
        for(int i = 0; i < n; i++) {
            if(prices[i] < minF) minF = prices[i];
            if(i > 0) fA[i] = Math.max(fA[i - 1], prices[i] - minF);
            if(prices[n-1-i] > maxB) maxB = prices[n-1-i];
            if(i > 0) bA[n - 1 - i] = Math.max(bA[n - i], maxB - prices[n - 1 - i]);
        }
        for(int i = 0; i < n; i++) {
            max = Math.max(max, fA[i] + bA[i]);
        }
        return max;
    }
}