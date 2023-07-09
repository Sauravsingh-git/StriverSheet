package Heaps.Hard;

import java.util.Arrays;

public class CutRod {
    // brute force is to cut the rod in all possible ways
    // time complexity : O(n^n)
    // space complexity : O(n) auxillary space

    // using memoization
    // time complexity : O(n^2)
    // space complexity : O(n)
    int [] dp;
    public int cutRod(int price[], int n) {
        dp = new int [n+1];
        Arrays.fill( dp, -1);
        return cutRodUtil( price, n);
    }
    
    public int cutRodUtil( int [] price, int remainingLen){
        if ( remainingLen == 0 ) return 0;
        
        if ( dp[remainingLen] != -1) return dp[remainingLen];
        int max = 0; 
        for ( int i = 1; i <= remainingLen; i++ ){
            max = Math.max( max, price[i-1] +  cutRodUtil( price, remainingLen - i));
        }
        return dp[ remainingLen ] = max;
    }
}
