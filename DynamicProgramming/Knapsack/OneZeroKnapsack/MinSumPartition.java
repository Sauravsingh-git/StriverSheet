package DynamicProgramming.Knapsack.OneZeroKnapsack;

import java.util.Arrays;

public class MinSumPartition {
    // using dp
    public int minDifference ( int num [], int n ){
        int totalSum = 0;
        for ( int ele : num ){
            totalSum += ele;
        }
        boolean [][] dp = new boolean [n+1][totalSum/2 + 1];
        for ( int i = 0; i <= n; i++ ){
            for ( int j = 0; j <= totalSum/2; j++ ){
                if ( j == 0 ) dp[i][j] = true;
                else if ( i == 0 ) dp[i][j] = false;
                else if ( j >= num[i-1] ){
                    dp[i][j] = dp[i-1][j- num[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        int absMinDiff = Integer.MAX_VALUE;
        for ( int i = totalSum/2; i >= 0; i-- ){
            if ( dp[n][i] ){
                absMinDiff =  totalSum - 2 * i;
                break;
            }
        }
        return absMinDiff;
    }
	public int minDifferenceMemo(int arr[], int n) 
	{ 
	    int totalSum = 0;
	    for ( int ele : arr )
	        totalSum += ele; 
	   
	   int [][] dp = new int [n + 1][totalSum+1];
	   for ( int [] ar : dp )
	    Arrays.fill(ar, -1);
	   return solveMemo(arr, 0, 0, totalSum, dp);
	    
	} 

    private int solveMemo ( int [] nums, int idx, int currSum, int totalSum, int [][] dp){
        if ( idx == nums.length ){
            return Math.abs(totalSum - 2 * currSum);
        }
        
        if ( dp[idx][currSum] != -1 ) return dp[idx][currSum];
        
        return dp[idx][currSum] = Math.min( solveMemo ( nums, idx + 1, currSum + nums[idx], totalSum, dp ), 
        solveMemo( nums, idx + 1, currSum, totalSum, dp));
    }
    // recursion 
	public void solveRecursion( int [] nums, int idx, int currSum, int totalSum, int [] absMinDiff){
        if ( idx == nums.length ){
            absMinDiff[0] = Math.min(absMinDiff[0], Math.abs( 2 * currSum - totalSum ) );
            return; 
        }

        // take it 
        solveRecursion(nums, idx+1, currSum + nums[idx], totalSum, absMinDiff);

        // leave it 
        solveRecursion(nums, idx+1, currSum, totalSum, absMinDiff);
    }
}
