/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(map.containsKey(key)) map.get(key).add(strs[i]);
            else map.put(key, new ArrayList<String>(Arrays.asList(strs[i])));
        }
        for(ArrayList<String> sub : map.values()) {
            if(sub.size() > 1) res.addAll(sub);
        }
        return res;
    }
}