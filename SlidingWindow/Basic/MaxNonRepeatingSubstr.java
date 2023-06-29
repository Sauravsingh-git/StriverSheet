package SlidingWindow.Basic;

import java.util.HashSet;
import java.util.Set;

public class MaxNonRepeatingSubstr {
    //brute force  : generate all the substrings possible
    // then  check if they contain repeating characters
    // time complexity : O(n^3) since substring also takes O(n) time
    // space complexity : O(n)
    public int lengthOfLongestSubstringBF(String s) {
        int len = s.length();
        int maxNonRepeatingSubstrLen = 0;
        for ( int i = 0; i < len; i++ ){
            for ( int j = i; j < len; j++ ){
                String currSubstring = s.substring(i, j+1);
                if ( !containsRepeatingCharacter(currSubstring))
                    maxNonRepeatingSubstrLen = Math.max( maxNonRepeatingSubstrLen, j -i + 1);
                
            }
        }
        return maxNonRepeatingSubstrLen;
    }

    public boolean containsRepeatingCharacter ( String str ){
        Set<Character> set = new HashSet<>();
        for ( int i = 0;  i < str.length(); i++ ){
            if ( set.contains(str.charAt(i))) return true;
            set.add(str.charAt(i));
        }
        return false;
    }

    // using sliding window 
    // time complexity : O(n)
    // space complexity : O(n)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxNonRepeatingSubstr = 0;
        int start = 0, end = 0;
        int len = s.length();
        while ( end < len ){
            char currChar = s.charAt(end);
            if( set.contains(currChar) ){
                while ( start < end && s.charAt(start) != currChar){
                    set.remove(s.charAt(start));
                    start++;
                }

                start++;
            }
            set.add(currChar);
            maxNonRepeatingSubstr = Math.max( maxNonRepeatingSubstr, end - start + 1);
            end++;
        }

        return maxNonRepeatingSubstr;
    }
}
