/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        if(path == null) return path;
        Stack<String> s = new Stack<String>();
        String res = "";
        String[] strs = path.split("/");
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].equals("..")) {
                if(!s.empty()) s.pop();
            }
            else if(!strs[i].equals(".") && strs[i].length() != 0) {
                s.push(strs[i]);
            }
        }
        if(s.empty()) return "/";
        while(!s.empty()) {
            res = "/" + s.pop() + res;
        }
        return res;
    }
}