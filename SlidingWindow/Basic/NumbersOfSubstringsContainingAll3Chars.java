package SlidingWindow.Basic;

public class NumbersOfSubstringsContainingAll3Chars {
    // brute force approach : 
    // generate all substrings and then check if they satisfy the condition
    // time complexity : O(N^3)
    // space complexity : O(1)

    // 2nd approach
    // for atMost 3 chars = n * ( n + 1)/2
    // calcuate for atMost2Chars
    // return atMost3Chars - atMost2Chars
    // time complexity : O(n)
    // space complexity : O(1)

    // optimized appraoch
    // when all the 3 charaters are present
    // add len - end to totalSubstringsCount i.e., totalSubstringsCount = len - end
    // and then increase start and charMap[str[start] -'a']--
    // we do this since for every substring after this condition is hit will contain 3 chars
    public int numberOfSubstrings(String s) {
        int [] map = new int [3];
        int start, end;
        start = end = 0;
        int len = s.length();
        int count = 0;
        while ( end < len){
            map[s.charAt(end)-'a']++;
            while ( map[0] > 0 && map[1] > 0 && map[2] > 0){
                // we are adding len - right to the count 
                // because we already have 3 letters with us
                // so all the substrings from [left, right], [left, right+1], [left, right+2], .... [left to len-1] will be a valid substring
                count += len - end;
                map[s.charAt(start)-'a']--;
                start++;
            }
            end++;
        }

        return count;
    }
}
