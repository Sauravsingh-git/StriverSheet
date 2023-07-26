package Recursion.Basic;

public class TowerOfAtoi {
    long total;
    // recursive method
    // time complexity : O(n)
    // space commplexity: O(n) auxillary space
    public int myAtoi(String s) {
        total = 0;
        return myAtoi(s, 0, true, false);
    }

    public int myAtoi(String str, int idx, boolean isPositive, boolean numberStarted){
        if ( idx == str.length()) return 0;
        char currChar = str.charAt(idx);
        if(!numberStarted){            
            if ( currChar == ' ') return myAtoi(str, idx+1, isPositive, numberStarted);
            if ( currChar == '-' ) return myAtoi(str, idx+1, false, true);
            if ( currChar == '+') return myAtoi(str, idx+1, true, true);
        }
        numberStarted = true;
        if( !isNumber(currChar)) return 0;
        total = total * 10 + (currChar - '0');
        if ( total > Integer.MAX_VALUE )
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int temp = myAtoi(str, idx+1, isPositive, numberStarted);
        if ( temp == 0 ) return isPositive ? (int)total : (int)-total;
        return temp;
    }

    public boolean isNumber(char ch ){
        return ch >= '0' && ch <= '9';
    }
}
