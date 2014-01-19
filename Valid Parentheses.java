/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(' : stack.push(c); break;
                case '[' : stack.push(c); break;
                case '{' : stack.push(c); break;
                case ')' : if(stack.empty()) return false;
                            if(stack.pop() != '(') return false;
                            break;
                case ']' : if(stack.empty()) return false;
                            if(stack.pop() != '[') return false;
                            break;
                case '}' : if(stack.empty()) return false;
                            if(stack.pop() != '{') return false;
                            break;
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}