package Recursion.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // dp approach ( Bottom up approach )
    // bottom up since we start from first possible partition and then check if first part is possible
    // intuition : for the current partition, check if first part can be segmented using the words of dictionary
    // for this we have to 2 cases, either the whole word should be present or 
    // the currWord is smaller than then  the partition, so segmentation will only be possible
    // if remainingPart of first part is also possible
    // time complexity : O(n*m*k)
    // n -> length of the word
    // m -> total words in dictionary
    // k -> length of biggest word in dictionary
    public boolean wordBreak(String s, List<String> wordDict ){
        int len = s.length();
        boolean [] dp = new boolean [len];

        for ( int partition = 0; partition < len; partition++ ){
            for ( String currWord : wordDict ){
                if ( currWord.length() > partition + 1 ) continue;

                if ( currWord.length() == partition + 1 || dp[partition - currWord.length()] ){
                    if ( currWord.equals( s.substring( partition + 1 - currWord.length(), partition + 1) ) ){
                        dp[partition] = true;
                        // break is just for optimization, since why  would we need to process further if
                        // we have already established than this partition can be achieved
                        break;
                    }
                }
            }
        }

        return dp[len-1];
    }

    // memoized appraoch ( Top down approach )
    //  its top down since, in the first word we are calling for the entire string
    // and after that we check for the smaller strings
    // Intuition : It is similar to palindrome partitioning, since we try all the partitions
    // possible and check if partition at the current place could give us a word in dict
    // if it does we just return if the leftSubstring can be formed from the words of the dict
    // the base case would be if the string is empty
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        wordDict.forEach(word-> set.add(word));
        return wordBreakUtil(s, new HashMap<String, Boolean>(),  set);
    }

    private boolean wordBreakUtil( String s,HashMap<String, Boolean>hashMap, Set<String> set){
        if ( s.isEmpty() ){
            return true;
        }
        if ( hashMap.containsKey(s) ) return hashMap.get(s);

        for ( int i = 1; i <= s.length(); i++ ){
            String firstWord = s.substring(0, i);
            if ( set.contains(firstWord) ){
                hashMap.put(firstWord, true);
                if ( wordBreakUtil(s.substring(i), hashMap, set )) return true;
            }
        }
        // if the currString is not available in dictionary then put false in hashMap
        hashMap.put(s, false);
        return false;

    }

    // private boolean wordBreakUtil( String s,Set<String> set){
    //     if ( s.isEmpty() ){
    //         return true;
    //     }

    //     for ( int i = 1; i <= s.length(); i++ ){
    //         String firstWord = s.substring(0, i);
    //         if ( set.contains(firstWord) ){
    //             if ( wordBreakUtil(s.substring(i), set )) return true;
    //         }
    //     }
    //     return false;

    // }
}
