/*
Implement int sqrt(int x).
Compute and return the square root of x.
*/
public class Solution {
    public int sqrt(int x) {
        long low = 0;
        long high = ((long)x+1)/2; //or long high = x/2 + 1; if x == 2,147,483,647, then x+1 will become negative
        while(low <= high) {
            long middle = (low + high) / 2;
            if(x == middle * middle) return (int)middle; // taking the mid of a big value and computing its square may overflow the int type
            if(x > middle * middle) low = middle + 1;
            else high = middle - 1;
        }
        return (int)high;
    }
}