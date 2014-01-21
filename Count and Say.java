/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        String count = "1";
        String say = "1";
        while(n > 1) {
            int num = 1;
            say = "";
            for(int i = 0; i < count.length(); i++) {
                if(i < count.length() - 1 && count.charAt(i) == count.charAt(i + 1)) {
                    num++;
                }
                else {
                    say = say.concat(String.valueOf(num));
                    say = say.concat(String.valueOf(count.charAt(i)));
                    num = 1;
                }
            }
            count = say;
            n--;
        }
        return say;
    }
}