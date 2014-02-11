/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;
        int max = 0;
        for(int i = 0; i < points.length - 1; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int add = 0;
            for(int j = i+1; j < points.length; j++) {
                int x1 = points[i].x, y1 = points[i].y, x2 = points[j].x, y2 = points[j].y;
                if(x1 == x2 && y1 == y2) {
                    add++;
                    continue;
                }
                double slope;
                if(x1 == x2) slope = Integer.MAX_VALUE;
                else if(y1 == y2) slope = 0;
                else slope = ((y1 - y2) * 1.0) / (x1 - x2);
                if(map.containsKey(slope)) {
                    map.put(slope, map.get(slope)+1);
                }
                else map.put(slope, 2);
            }
            if(map.size() == 0) {
                max = Math.max(max, ++add);
            }
            for(Double key : map.keySet()) {
                max = Math.max(max, map.get(key) + add);
            }
        }
        return max;
    }
}