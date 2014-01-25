/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null) return true;
        s = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while(low < high) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);
            if(lowChar - '0' < 0 || lowChar - 'z' > 0 || (lowChar - '9' > 0 && lowChar - 'a' < 0)) {
                low++;
                continue;
            }
            if(highChar - '0' < 0 || highChar - 'z' > 0 || (highChar - '9' > 0 && highChar - 'a' < 0)) {
                high--;
                continue;
            }
            if(lowChar != highChar) return false;
            low++;
            high--;
        }
        return true;
    }
}