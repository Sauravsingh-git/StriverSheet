package SlidingWindow.Basic;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {
    // recurrence + dp solution
    // try every single possibility to choose the best way
    // time complexity : O(2^n) for reccurence
    // space complexity : O(1) for reccurence
    // time complexity : O(m*n) for reccurence + memoization
    // space complexity : O(m*n) for reccurence + memoization
    public int maxScoreBF(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int [][] dp = new int [len][len];
        for ( int [] arr : dp )
            Arrays.fill(arr, -1);
        return maxScoreUtil(cardPoints, k, 0, len-1, dp);
    }
    public int maxScoreUtil( int [] cardPoints, int k, int lb, int ub, int [][] dp){
        if ( k == 0 ) return 0;
        if ( dp[lb][ub] != -1 ) return dp[lb][ub];
        return dp[lb][ub] = Math.max( cardPoints[lb] + maxScoreUtil( cardPoints, k-1, lb+1, ub, dp), cardPoints[ub] + maxScoreUtil(cardPoints, k-1, lb, ub-1, dp));
    } 

    // using sliding window
    // imagine an the same array is appended to the end of the array
    // since the elements can be extracted only from the last and front
    // our possibilities will be continous subarray
    // time compelxity : O(n)
    // space complexity : O(1)
    public int maxScore( int [] cardPoints, int k ){
        int currSum, currMax, start, end;
        currSum = currMax = 0;
        int len = cardPoints.length;
        start = end = len-k;
        while ( start < len ){
            currSum += cardPoints[(end%len)];
            if ( end - start + 1 > k ){
                currSum -= cardPoints[start%len];
                start++;
            }
            currMax = Math.max(currSum, currMax);
            end++;
        }
        return currMax;
    }
}
