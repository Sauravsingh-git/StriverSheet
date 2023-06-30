package SlidingWindow.Basic;

public class NiceArrays {
    // brute force
    // generate all subarrays 
    // then check if they have k odd numbers
    // time complexity : O(N^3)
    // space complexity : O(1), constant space
    // we can optimize this approach further, and reduce time compelxity to O(N^2) time complexity =
    public int numberOfSubarraysBF(int[] nums, int k) {
        int len = nums.length;
        int niceArrays = 0;
        for ( int i = 0; i < len; i++ ){
            for ( int j = 0; j < len; j++ ){
                if(haveKOddNumbers( nums, k, i, j+1))
                    niceArrays++;
            }
        }
        return niceArrays;
    }

    public boolean haveKOddNumbers ( int [] nums, int k, int lb, int ub ){
        int odds = 0;
        for ( int i = lb; i < ub; i++ ){
            if ( (nums[i]&1) == 1 ) odds++;
        }
        return odds == k;
    }

    // approach 2 : can also be done as number of subarrays with sum K
    // time complexity : O(n)
    // space complexity : O(n)
    public int numberOfSubarrays( int [] nums, int k ){
        int len = nums.length;
        int [] odds = new int [len+1];
        int currOdds = 0, subarrays = 0;
        for ( int i = 0; i < len; i++ ){
            currOdds += (nums[i]&1);
            if ( currOdds == k) subarrays++;
            if (currOdds >= k && odds[currOdds -k] > 0 )
                subarrays += odds[currOdds-k];
            odds[currOdds]++;
        }
        return subarrays;
    }

    // using atmostk(k) - atmostk(k-1)
    // time complexity : O(n)
    // space complexity : O(1)
    public int numberOfSubarraysO( int [] nums, int k){
        return atMostKOdds(nums, k) - atMostKOdds( nums, k-1);
    }

    public int atMostKOdds( int [] nums, int k){
        if ( k < 0 ) return 0;
        int start, end, odds, subarrays;
        start = end = odds = subarrays = 0;
        int len = nums.length;
        while ( end < len){
            if ( (nums[end]&1) == 1) odds++;
            if ( odds > k ){
                while ( start <= end && odds > k ){
                    if ( (nums[start]&1) == 1) odds--;
                    start++;
                }
            }
            subarrays += end - start + 1;    
            end++;        
        }
        return subarrays;
    }
}
