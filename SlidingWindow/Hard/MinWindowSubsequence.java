package SlidingWindow.Hard;

public class MinWindowSubsequence {
    // brute force approach
    // genarate all the substrings
    // check if curr substring is a subsequence
    // update the minWindow which satisfies this condition
    // time complexity : O(n^3)
    // space complexity : O(1)


    // using sliding window
    // time complexity : O(n^2)
    // space complexity : O(1)
    String minWindow(String str1, String str2) {
        int idx1, idx2;
        idx1 = idx2 = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int start = 0;
        int minWindow = str1.length()+1;
        while ( idx1 < len1 ){

            if ( str1.charAt(idx1) == str2.charAt(idx2) ){
                idx2++;
            }
            if ( idx2 == len2){
                int end = idx1;
                idx2--;
                while ( idx2 >= 0 ){ 
                    if ( str1.charAt(idx1) == str2.charAt(idx2))
                        idx2--;
                    idx1--;
                }
                idx1++;
                idx2++;
                if ( minWindow > end - idx1 + 1){
                    minWindow = end - idx1 + 1;
                    start = idx1;
                }
            }
            idx1++;
        }
        
        return minWindow == len1 + 1 ? "" : str1.substring(start, start + minWindow);
    }
}
