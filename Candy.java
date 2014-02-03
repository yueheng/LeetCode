/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;
        int n = ratings.length;
        int[] res = new int[n];
        int can = 0;
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) res[i] = res[i - 1] + 1;
            else res[i] = 1;
        }
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) res[i] = Math.max(res[i + 1] + 1, res[i]);
        }
        for(int i = 0; i < n; i++) can += res[i];
        return can;
    }
}