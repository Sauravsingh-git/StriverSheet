package String.Medium;

public class LongestPalindromicSubstring {

    // most optimised approach 
    // EXPAND FROM THE MIDDLE
    // time complexity : O(n^2)
    // space complexity : O(1)
    public String longestPalindrome(String s) {
        int len,len1, len2;
        int start, end;
        start = end = 0;
        for(int i=0; i<s.length(); i++){
            // for the cases when palindrome has odd length;
            len1 = expandFromTheMiddle(s, i, i);
            // for the cases when palindrom has even length;
            len2 = expandFromTheMiddle(s, i, i+1);
            len = Math.max(len1, len2);
            if(len>end-start){
                start = i - (len-1)/2; // since we are checking at i and i+1 for even palindrome the correct position of start would be at i-(len-1)/2
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expandFromTheMiddle(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    // using dp 
    // time complexity : O(n^2)
    // space complexity : o(n^2)

    public String longestPalindrome1(String s) {
        int len = s.length();
        boolean [][] dp = new boolean [len][len];
        int resultStart = 0, resultEnd = 0;

        // since all the one character substrings are palindromes
        for ( int i = 0; i < len; i++  ){
            dp[i][i] = true;
        }

        //mark all the substrings of len 2 which are palindromes
        for ( int i = 0; i < len-1; i++ ){
            if ( s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                resultStart = i;
                resultEnd = i+1;
            }
        }

        for ( int diff = 2; diff < len; diff++){
            for ( int i = 0; i < len - diff; i++ ){
                int j = i + diff;
                if ( s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    resultStart = i;
                    resultEnd = j;
                }
            }
        }

        return s.substring(resultStart, resultEnd+1);
        
    }

    // brute force approach 
    // generate all the substrings
    // check if they are all palindromes
    // time complexity : O(n^3)
    // space complexity : O(1)
}
