package SlidingWindow.Hard;

public class MaxSubstrWithKUniqueChars {
    // brute force will be to generate every substring possible 
    // then check if it contains exactly k unique characters
    // time complexity : O(n^3)
    // space complexity : O(1)
    
    // optimized approach
    // using charMap and currCharCount variable
    // time complexity : O(n)
    // space complexity : O(1)
    public int longestkSubstr(String s, int k) {
        int [] charMap = new int [26];
        int currCharCount = 0;
        int start, end, maxSubstrLen, maxCharCount;
        start = end = maxSubstrLen = maxCharCount= 0;
        int len = s.length();
        while ( end < len ){
            char currChar = s.charAt(end);
            charMap[currChar - 'a']++;
            if ( charMap[currChar - 'a'] == 1 ){
                currCharCount++;
                maxCharCount = Math.max(maxCharCount, currCharCount);
            }
                
            while ( k < currCharCount ){
                char charAtStart = s.charAt(start);
                charMap[charAtStart - 'a']--;
                if(charMap[charAtStart - 'a'] == 0 ) currCharCount--;
                start++;
            }
            
            maxSubstrLen = Math.max(maxSubstrLen, end - start + 1);
            end++;
        }
        return (maxCharCount < k) ? -1 : maxSubstrLen;
    }
}
