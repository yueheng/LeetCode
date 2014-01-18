/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        res.add(1);
        while(rowIndex > 0) {
            res.add(1);
            for(int i = res.size() - 2; i > 0; i--) {
                res.set(i, res.get(i) + res.get(i - 1));
            }
            rowIndex--;
        }
        return res;
    }
}