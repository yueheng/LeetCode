/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Comparator<Interval> com = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if(a.start < b.start) return -1;
                else if(a.start > b.start) return 1;
                else return 0;
            }
        };
        Collections.sort(intervals, com);
        int i = 0;
        int j = 0;
        int n = intervals.size();
        ArrayList<Interval> res = new ArrayList<Interval>();
        while(i < n) {
            if(i == 0) res.add(intervals.get(i));
            else {
                if(intervals.get(i).start <= res.get(j).end) {
                    res.get(j).end = Math.max(intervals.get(i).end, res.get(j).end);
                }
                else {
                    res.add(intervals.get(i));
                    j++;
                }
            }
            i++;
        }
        return res;
    }
}
