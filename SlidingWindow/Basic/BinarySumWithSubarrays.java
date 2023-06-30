package SlidingWindow.Basic;

import java.util.HashMap;

public class BinarySumWithSubarrays {
    // brute force 
    // generate all the subarrays and then check which subarrays satisfy the condition
    // time complexity : O(N^3)
    // space complexity : O(1)
    public int numSubarraysWithSumBF(int[] nums, int goal) {
        int len = nums.length;
        int counter = 0;
        for ( int i = 0; i < len; i++ ){
            for ( int j = i; j < len; j++ ){
                if (isEqualToTarget( nums, i, j+1, goal))
                    counter++;
            }
        }
        return counter;
    }

    public boolean isEqualToTarget ( int [] arr, int lb, int ub, int target ){
        int sum = 0;
        for ( int i = lb; i < ub; i++ ){
            sum += arr[i];
        }
        return sum == target;
    }

    // semi optimized approach
    // time complexity : O(N^2)
    // space complexity : O(1), constant space
    public int numSubarraysWithSumSO(int[] nums, int goal) {
        int len = nums.length;
        int counter = 0;
        for ( int i = 0; i < len; i++ ){
            int sum = 0;
            for ( int j = i; j < len; j++ ){
                sum += nums[j];
                if ( sum == goal ) counter++;
            }
        }
        return counter;
    }

    // the same approach as number of subarrays with sum k
    // time complexity : O(n)
    // space complexity : O(n)

    public int numSubarraysWithSumSO1( int [] nums, int target){
        int len = nums.length;
        int counter = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < len; i++ ){
            prefixSum += nums[i];
            if ( prefixSum == target) counter++;
            // number of times when prefixSum - target was present
            counter += map.getOrDefault( prefixSum - target, 0);
            map.put( prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return counter;
    }

    // Most optimized approach
    // using 3 pointers
    // we will have to maintain 4 variables iLowSum, iLow, iHighSum, iHigh
    // for every j we will be counting iLow and iHigh
    // iLow -> smallest index such that sum(iLow, j) = target
    // iHigh -> largest index such that sum(iHigh, j) = target
    // then, update NumberOfSubarrays = iHigh - iLow +1;
    // time complexity : O(n)
    // space complexity : O(1)
    public int numSubarraysWithSumO( int [] nums, int target){
        int iLowSum, iLow, iHighSum, iHigh;
        iLow = iLowSum = iHigh = iHighSum = 0;
        int len = nums.length, j = 0;
        int counter = 0;
        while ( j < len){
            // setting iLow
            iLowSum += nums[j];
            while ( iLow < j && iLowSum > target){
                iLowSum -= nums[iLow];
                iLow++;
            }
            // setting iHigh
            iHighSum += nums[j];
            while ( iHigh < j && (iHighSum > target||(iHighSum == target && nums[iHigh] == 0))){
                iHighSum -= nums[iHigh];
                iHigh++;
            }

            if (iLowSum == target)
                counter += iHigh - iLow + 1;
            j++;
        }

        return counter;
    }

    // most optimized approach 2
    // we will find all subarrays with atmost sum target i.e, 0, 1, 2, ... , target
    // then we will subtract subarrays with atmost sum target -1
    // time complexity : O(n)
    // space complexity : O(1)
    public int numSubarraysWithSum( int [] nums, int target){
        return atMostSum(nums, target) - atMostSum( nums, target - 1);
    }

    public int atMostSum( int [] nums, int target){
        if( target < 0) return 0;
        int start, end, subarrays;
        start = end = subarrays = 0;
        int len = nums.length;
        int currSum = 0;
        while ( end < len ) {
            currSum += nums[end];
            if ( currSum > target ){
                while ( start <= end && currSum > target){
                    currSum -= nums[start];
                    start++;
                }
            }
            subarrays += end - start + 1;
            end++;
        }
        return subarrays;
    }
}
