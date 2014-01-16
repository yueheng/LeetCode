/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return res;
        ArrayList<Integer> sub0 = new ArrayList<Integer>();
        sub0.add(1);
        res.add(sub0);
        while(numRows > 1) {
            ArrayList<Integer> prev = res.get(res.size() - 1);
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(1);
            for(int i = 0; i < prev.size() - 1; i++) {
                int temp = prev.get(i) + prev.get(i + 1);
                sub.add(temp);
            }
            sub.add(1);
            res.add(sub);
            numRows--;
        }
        return res;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0) return res;
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        res.add(row1);
        if(numRows == 1) return res;
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(1);
        row2.add(1);
        res.add(row2);
        if(numRows == 2) return res;
        ArrayList<Integer> last = row2;
        for(int i = 3; i <= numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            Iterator<Integer> iter = last.iterator();
            int prev = iter.next();
            while(iter.hasNext()) {
                int temp = iter.next();
                row.add(prev + temp);
                prev = temp;
            }
            row.add(1);
            res.add(row);
            last = row;
        }
        return res;
    }
}