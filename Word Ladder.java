/*
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
/*
So we quickly realize that this looks like a tree searching problem for which breath first guarantees the optimal solution.
*/
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int len = 0;
        if(start.equals(end)) return len;
        Queue<String> curr = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        curr.add(start);
        while(!curr.isEmpty()) {
            while(!curr.isEmpty()) {
                String temp = curr.remove();
                char[] array = temp.toCharArray();
                int length = temp.length();
                for(int i = 0; i < length; i++) {
                    char ch = array[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(ch == c) continue;
                        array[i] = c;
                        String newstr = new String(array);
                        if(dict.contains(newstr) && end.equals(newstr)) return len+2;
                        if(dict.contains(newstr)) {
                            dict.remove(newstr);   //already visited
                            next.add(newstr);
                        }
                    }
                    array[i] = ch;
                }
            }
            Queue<String> temp = next;
            next = curr;
            curr = temp;
            len++;
        }
        return 0;
    }
}