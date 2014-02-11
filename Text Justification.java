/*
Given an array of words and a length L, format the text such that each line 
has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

//implement problem not algorithm
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) return res;
        int i = 0;
        int len = words.length;
        while(i < len) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            int templen = words[i].length();
            int j = i+1;
            while(j < len && templen +1 + words[j].length() <= L) {
                templen += 1 + words[j].length() ;  //the length of words + whitespace
                j++;
            }
            j--;
            int interval = j-i;
            if(interval == 0) {
                while(templen < L) {
                    sb.append(" ");
                    templen++;
                }
            }
            else {
                if(j == len-1) {   //last line
                    templen = words[i].length();
                    while(++i < len) {
                        sb.append(" ");
                        sb.append(words[i]);
                        templen += 1 + words[i].length();
                    }
                    while(templen < L) {
                        sb.append(" ");
                        templen++;
                    }
                }
                else {            //not last line
                    int addspace = (L - templen) / interval;
                    int addmore = (L - templen) % interval;
                    while(interval > 0) {
                        for(int k = 0; k <= addspace; k++) {
                            sb.append(" ");
                        }
                        if(addmore > 0) {
                            sb.append(" ");
                            addmore--;
                        }
                        sb.append(words[++i]);
                        interval--;
                    }
                }
            }
            res.add(sb.toString());
            i++;
        }
        return res;
    }
}