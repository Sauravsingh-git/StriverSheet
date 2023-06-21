package BinarySearch.FindingAnswersByBs;

public class MinDivisorPossible {
    // brute force approach
    // time complexity : O(10^6 * N) -> total time complexity : O(10^12) operations -> very high time complexity
    // space complexity : O(1)
    public int smallestDivisorBF(int[] nums, int threshold) {
        int minDivisorPossible = nums[0];
        for ( int ele : nums ) 
            minDivisorPossible = Math.max( minDivisorPossible, ele );
        
        while ( canDivideWithinThreshold( nums, minDivisorPossible, threshold))
            minDivisorPossible -= 1;

        return minDivisorPossible +1;
    }


    //using binary search to reduce search space
    // time complexity : O( 20 * N) -> O(N)
    // space complexity : O(1)

    public int smallestDivisor( int [] nums, int threshold){
        int low = 1;
        int high = 1000000;
        int minDivisorPossible = -1;
        while ( low <= high ){
            int mid = ( low + high ) >> 1;
            if ( canDivideWithinThreshold( nums, mid, threshold)){
                minDivisorPossible = mid;
                high = mid-1;
            }
            else 
                low = mid+1;
        }
        return minDivisorPossible;
    }
    public boolean canDivideWithinThreshold( int [] nums, int divisor, int threshold){
        int sum = 0;
        for ( int ele : nums )
            sum += ele/divisor + ( ele%divisor == 0 ? 0 : 1);
        
        return sum <= threshold;
    }
}
