package Recursion.SubsequencePattern;

import java.util.Arrays;

public class SubsequenceSumEqualToK {
    static int [][] dp;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        dp = new int [n+1][k+1];
        for ( int [] ar : dp ){
            Arrays.fill(ar, -1);
        }

        return subsetSumToKUtil(arr, 0 , k, 0) == 1;
    }

    public static int subsetSumToKUtil(int [] arr, int sum, int target, int idx ){
        if ( idx == arr.length ){
            if (target == sum) 
                return dp[idx][sum] = 1;
            else   
                return 0;
        }

        if ( sum > target ) return 0;
        if ( target == sum ) return dp[idx][sum] = 1;
        if ( dp[idx][sum] != -1 ) return dp[idx][sum];
        // not choosing the element at the curr idx
        if (subsetSumToKUtil(arr, sum, target, idx+1) == 1 ) return dp[idx][sum] = 1;

        // choosing the element at the currIdx
        if ( subsetSumToKUtil(arr, sum + arr[idx], target, idx+1) == 1) return dp[idx][sum] = 1;
        return dp[idx][sum] = 0;
    }
}