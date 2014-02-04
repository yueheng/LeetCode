/*
You are given a string, S, and a list of words, L, that are all of the same length. 
Find all starting indices of substring(s) in S 
that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        int slen = S.length();
        int llen = L.length;
        int wlen = L[0].length();
        for(String word : L) {
            if(!hashmap.containsKey(word)) hashmap.put(word, 1);
            else hashmap.put(word, hashmap.get(word) + 1);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= slen - llen * wlen; i++) {
            if(hashmap.containsKey(S.substring(i, i + wlen))) {
                int j = i;
                String sub = S.substring(j, j + wlen);
                HashMap<String, Integer> map = new HashMap<String, Integer>(hashmap);
                while(map.containsKey(sub) && map.get(sub) > 0) {
                    map.put(sub, map.get(sub) - 1);
                    j += wlen;
                    if(j+wlen <= slen)sub = S.substring(j, j + wlen);
                    else break;
                }
                if(j == i + llen * wlen)  res.add(i);
            }
        } 
        return res;
    }
}