package SlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    // brute force of this would to generate every substring
    // then check if its substring is s2
    // sliding window
    // the main trick is to create hashmap of s2
    // and decrease from that map
    // time complexity : O(n + m)
    // space complexity : O(m)
    public String minWindow(String s1, String s2) {
        int start, end, minWindow, len, windowStart;
        len = s1.length();
        start = end = windowStart = 0;
        minWindow = len + 1;
        Map<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < s2.length(); i++ ){
            char currChar = s2.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        int remainingChars = map.size();
        while ( end < len ){
            char currChar = s1.charAt(end);
            if ( map.containsKey( currChar )){
                map.put(currChar, map.get(currChar) -1);
                if ( map.get(currChar) == 0 ) remainingChars--;
            }

            if( remainingChars == 0 ){
                while ( remainingChars == 0 ){
                    if ( end - start + 1 < minWindow){
                        minWindow = end - start + 1;
                        windowStart = start;
                    }
                    char startChar = s1.charAt(start);
                    if( map.containsKey(startChar)){
                        map.put(startChar, map.get(startChar)+1);
                        if ( map.get(startChar) == 1) remainingChars++;
                    }
                    start++;
                }
            }
            end++;
        }
        return minWindow == len+1 ? "" : s1.substring(windowStart, windowStart + minWindow);
    }
}
