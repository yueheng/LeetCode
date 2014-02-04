/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int len = 1;
        int max = 1;
        for(int i = 1; i < num.length; i++) {
            if(num[i] == num[i-1]) continue;
            if(num[i] == num[i-1] + 1) {
                len++;
            }
            else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}

/*
The key factors about a cluster is: lowest, highest, and length.
Map lowest and highest to length. To merge two neighbor clusters, 
only need to update it's new lowest and highest, with new length.
For every a[i], checking its neighbor a[i]-1 and a[i]+1 is enough.
*/
public class Solution {
    public int longestConsecutive(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for(int i : num) {
            if(map.containsKey(i)) continue;
            map.put(i, 1);
            if(map.containsKey(i - 1)) max = Math.max(max, Merge(map, i - 1, i));
            if(map.containsKey(i + 1)) max = Math.max(max, Merge(map, i, i + 1));
        }
        return max;
    }
    
    public int Merge(Map<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) -1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
}