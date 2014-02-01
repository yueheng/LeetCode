/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].matches("-*\\d+")) {
                s.push(Integer.parseInt(tokens[i]));
            }
            else {
                int b = s.pop();
                int a = s.pop();
                int res = 0;
                switch(tokens[i]) {
                    case "+" : res = a + b; break;
                    case "-" : res = a - b; break;
                    case "*" : res = a * b; break;
                    case "/" : res = a / b; break;
                }
                s.push(res);
            }
        }
        return s.pop();
    }
}