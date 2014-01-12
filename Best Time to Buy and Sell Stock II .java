/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
       int buyprice = 0;
       int res = 0;
       int i = 0;
       boolean buy = true;
       for(; i < prices.length - 1; i++) {
           if(prices[i] < prices[i + 1] && buy == true) {
               buyprice = prices[i];
               buy = false;
           }
           if(prices[i] > prices[i + 1] && buy == false) {
               res += prices[i] - buyprice;
               buy = true;
           }
       }
       if(buy == false && prices[i] > buyprice) res += prices[i] - buyprice;
       return res;
    }
}