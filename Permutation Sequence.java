/*
The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        int all = 1;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            all *= i;
            num.add(i);
        }
        for(int i = n; i >= 1; i--) {
            all /= i;
            int q = (k - 1) / all;
            k = k - q * all;
            res.append(num.get(q));
            num.remove(q);
        }
        return res.toString();
    }
}