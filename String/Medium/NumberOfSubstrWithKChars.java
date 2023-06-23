package String.Medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfSubstrWithKChars {
    // time complexity : O(k *n^2)
    // space commplexity : O(k)
    long substrCount (String S, int K) {
        long totalCount = 0;
        int len = S.length();
        for ( int i = 0; i < len; i++ ){
            for ( int j = i; j < len; j++ ){
                if(containsKLetters(S, i, j+1, K))
                    totalCount++;
            }
        }
        return totalCount;
    }
    
    public boolean containsKLetters(String s, int low, int high, int k){
        Set<Character> set = new HashSet<>();
        for ( int i = low; i < high; i++ ){
            set.add(s.charAt(i));
        }
        
        return set.size() == k;
    }
}
