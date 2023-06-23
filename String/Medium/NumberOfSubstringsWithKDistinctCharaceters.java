package String.Medium;

public class NumberOfSubstringsWithKDistinctCharaceters {
    // brute force approach would be to generate all the substrings
    // and then check if it contains only k distinct letters
    // time complexity : O (n^3)

    // optimized approach
    // using sliding window protocol
    // Time complexity : O(n) n -> len(str)
    // space complexity : O(1)
    long substrCount(String s, int k){
        return substrCountUtil(s, k) - substrCountUtil(s, k-1);
    }
    
    long substrCountUtil( String s, int k ){
            if ( k == 0) return 0;
        int start = 0, end = 0;
        int elementsInWindow = 0;
        long count = 0;
        int len = s.length();
        int [] charMap = new int [26];
        while ( end < len ){
            charMap[s.charAt(end)-'a']++;
            if ( charMap[s.charAt(end)-'a'] == 1) 
                elementsInWindow++;
            if ( elementsInWindow > k ){
                while ( elementsInWindow > k ){
                    if ( charMap[s.charAt(start)-'a'] == 1)
                        elementsInWindow--;
                    charMap[s.charAt(start)-'a']--;
                    start++;
                    
                }
            }
            
            count += end - start + 1;
            end++;
        }
        return count;
    }
}
