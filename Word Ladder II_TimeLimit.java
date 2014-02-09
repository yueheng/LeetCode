/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict)  {
           ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(start == null || end == null || dict == null) return res;
        Queue<String> curr = new LinkedList<String>();   //each level
        curr.add(start);
        Queue<ArrayList<String>> arrqueue = new LinkedList<ArrayList<String>>(); //conrresponding arraylist to curr
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(start);
        arrqueue.add(arr);
        while(!curr.isEmpty()) {
            int len = curr.size();
            for(int k = 0; k < len; k++) {
                String temp = curr.remove();                         
                ArrayList<String> templist = arrqueue.remove();
                dict.remove(temp);
                char[] array = temp.toCharArray();
                for(int i = 0; i < temp.length(); i++) {
                    char ch = array[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == ch) continue;
                        array[i] = c;
                        String newstr = new String(array);
                        if(newstr.equals(end)) {
                            ArrayList<String> sub = new ArrayList<String>(templist);
                            sub.add(newstr);
                            res.add(sub);
                                                          
                        }
                        else if(dict.contains(newstr)){                
                            ArrayList<String> sub = new ArrayList<String>(templist); 
                            sub.add(newstr);
                            curr.add(newstr);
                            arrqueue.add(sub);
                        }
                    }
                    array[i] = ch;
                }
            }
            if(res.size() != 0) return res;
        }
        return res;
     }
}



public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict)  {
           ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(start == null || end == null || dict == null) return res;
        Queue<String> curr = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        curr.add(start);
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<String>> startlist = new ArrayList<ArrayList<String>>();
        ArrayList<String> startlistsub = new ArrayList<String>();
        startlistsub.add(start);
        startlist.add(startlistsub);
        map.put(start, startlist);
        while(!curr.isEmpty()) {
            while(!curr.isEmpty()) {
                String temp = curr.remove();                         
                ArrayList<ArrayList<String>> templist = map.remove(temp);
                dict.remove(temp);
                if(templist == null) System.out.println("null temp : " + temp);
                char[] array = temp.toCharArray();
                for(int i = 0; i < temp.length(); i++) {
                    char ch = array[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == ch) continue;
                        array[i] = c;
                        String newstr = new String(array);
                        if(newstr.equals(end)) {
                                ArrayList<ArrayList<String>> sub = copy(templist);
                                for(int j = 0; j < sub.size(); j++) {
                                    sub.get(j).add(newstr);
                                    res.add(sub.get(j));
                                }                                
                        }
                        else if(dict.contains(newstr)){                            
                            if(!next.contains(newstr))next.add(newstr);
                            ArrayList<ArrayList<String>> sub = copy(templist); 
                            for(int j = 0; j < sub.size(); j++) {
                                sub.get(j).add(newstr);
                            }
                            if(map.containsKey(newstr)) {
                                ArrayList<ArrayList<String>> newstrtemp = map.get(newstr);
                                sub.addAll(newstrtemp);
                                map.put(newstr, sub);
                            }
                            else map.put(newstr, sub);
                        }
                    }
                    array[i] = ch;
                }
            }
            if(res.size() != 0) return res;
            Queue<String> temp = next;
            next = curr;
            curr = temp;
        }
        return res;
     }
     public ArrayList<ArrayList<String>> copy (ArrayList<ArrayList<String>> templist) {
         ArrayList<ArrayList<String>> sub = new ArrayList<ArrayList<String>>();
         if(templist == null) return sub;
         for(int j = 0; j < templist.size(); j++) {
                ArrayList<String> arr = templist.get(j);
                ArrayList<String> newarr = new ArrayList<String>();
                for(int k = 0; k < arr.size(); k++) {
                        String str = arr.get(k);
                        newarr.add(str);
                }
                sub.add(newarr);
        }
        return sub;
     }
}