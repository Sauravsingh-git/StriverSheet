package SlidingWindow.Basic;

public class MaxConsecutiveOnes {
    // brute force 
    // generate each subarray
    // then check if the number of zeros it contains can be flipped 
    // converting it into an array with all ones
    // time complexity : O(n^3)
    // space complexity : O(1)
    public int longestOnesBF(int[] nums, int k) {
        int longestOneSeries = 0;
        int len = nums.length;
        for ( int i = 0; i < len; i++ ){
            for ( int j = 0; j < len; j++ ){
                int zerosInArr = countZeros( nums, i, j+1);
                if ( zerosInArr <= k ){
                    longestOneSeries = Math.max( longestOneSeries, j-i+1);
                }
            }
        }
        return longestOneSeries;
    }

    public int countZeros( int  [] arr, int lb, int ub ){
        int zeros = 0;
        for ( int i = lb; i < ub; i++ ){
            if ( arr[i] == 0 ) zeros++;
        }   
        return zeros;
    }


    // sliding window
    // time complexity : O(n)
    // space complexity : O(n)
    public int longestOnes( int [] arr, int k ){
        int len = arr.length;
        int maxOnes = 0;
        int zeros, start, end;
        start = end = zeros = 0;
        while ( end < len){
            if ( arr[end] == 0 ){
                zeros++;
                if ( zeros > k ){
                    while ( start <= end && zeros > k ){
                        if ( arr[start] == 0 ) zeros--;
                        start++;
                    }
                }
            }
            maxOnes = Math.max(maxOnes, end - start + 1);
            end++;
        }
        return maxOnes;
    }
}
