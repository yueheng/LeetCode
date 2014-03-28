/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        String sub = "";
        helper(res, sub, s, dict);
        return res;
    }
    public void helper(ArrayList<String> res, String sub, String s, Set<String> dict) {
        if(s == null) return;
        if(s.length() == 0) {
            if(!res.contains(sub))res.add(sub);
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            if(dict.contains(s.substring(0, i))) {
                if(sub.length() == 0) helper(res, s.substring(0, i) , s.substring(i, s.length()), dict);
                else helper(res, sub + " " + s.substring(0, i) , s.substring(i, s.length()), dict);
            }
        }
    }
}




import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        String s = "catsanddog";
        String[] strs = {"cat", "cats", "and", "sand", "dog"};
        HashSet<String> dict = generate(strs);
        System.out.println(word(s, dict));
        
     }
     
     public static ArrayList<String> word(String s, HashSet<String> dict) {
         int n = s.length();
         //boolean[] valid = new boolean[n+1];
         //valid[0] = true;
         HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
         ArrayList<String> init = new ArrayList<String>();
         String initstr = "";
         init.add(initstr);
         map.put(0, init);
         for(int i = 0; i < n+1; i++) {
             for(int j = 0; j < i; j++) {
                 String sub = s.substring(j, i);
                 if(dict.contains(sub) && map.containsKey(j)) {                  
                     ArrayList<String> jarr = map.get(j);
                     ArrayList<String> iarr = null;
                     if(map.containsKey(i)) iarr = map.get(i);
                     else {
                    	 iarr = new ArrayList<String>();
                    	 map.put(i, iarr);
                     }
                     for(int k = 0; k < jarr.size(); k++) {
                         String temp = jarr.get(k);
                         String newtemp;
                         if(j == 0) newtemp = sub;
                         else newtemp = temp + " " + sub;
                         iarr.add(newtemp);                         
                     }
                 }
             }
         }
         return map.get(n);
     }
     
     public static HashSet<String> generate(String[] strs) {
         HashSet<String> dict = new HashSet<String>();
         for(int i = 0; i < strs.length; i++) dict.add(strs[i]);
         return dict;
     }
}

