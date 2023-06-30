package SlidingWindow.Basic;

public class LongestRepeatingCharacterReplacement {
    // brute force 
    // generate all  the substrings, then check if they satisfy the conditions
    // time complexity : O(N^3)
    // space complexity : O(N)
    public int characterReplacementBF(String s, int k) {
        int len = s.length();
        int maxSubstrPossible = 0;
        for ( int i = 0; i < len; i++ ){
            for ( int j = i; j < len; j++ ){
               int maxRepeatingChar = maxRepeatingCharacter(s, i, j + 1);
               if ( maxRepeatingChar + k >= j - i + 1)
                    maxSubstrPossible = Math.max(maxSubstrPossible, j - i + 1);
            }
        }
        return maxSubstrPossible;
    }

    public int maxRepeatingCharacter( String s, int lb, int ub){
        int maxRepeatingChar = 0;
        char [] str = s.toCharArray();
        int [] charMap = new int [26];
        for ( int i = lb; i < ub; i++ ){
            charMap[str[i] - 'A']++;
            maxRepeatingChar = Math.max( maxRepeatingChar, charMap[str[i] - 'A']);
        }
        return maxRepeatingChar;
    }

    // sliding window appraoch
    // maintain a currMaxChar and charMap[] arr, at every new char we encounter, we increase its corresponding index
    // after increasing the occurences of currChar, check if its maximum Char in current window, if its update currMaxChar
    // then moving condition for window will be if ( end - start + 1 - currMaxChar > k )
    // update the length of maximumReplacementSubstr everytime
    // time complexity : O(n)
    // space complexity : O(1)
    public int characterReplacement( String s, int k ){
        char [] str = s.toCharArray();
        int len = s.length();
        int start, end, maxReplacementSubstr;
        start = end = maxReplacementSubstr = 0;
        int currMaxChar = 0;
        int [] charMap = new int [26];
        while ( end < len ){
            charMap[str[end] - 'A']++;
            currMaxChar = Math.max(currMaxChar, charMap[str[end]-'A']);
            if ( start < end && end - start + 1 - currMaxChar > k){
                charMap[str[start] -'A']--;
                start++;
            }
            maxReplacementSubstr = Math.max(maxReplacementSubstr, end - start + 1);
            end++;
        }
        return maxReplacementSubstr;
    }
}
