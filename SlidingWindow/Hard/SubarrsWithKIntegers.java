package SlidingWindow.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarrsWithKIntegers {
    // brute force approach
    // generate all possible subarrays
    // then check if an arrays satisfies the condition of having K Different Integers
    // time complexity : O(n^3)
    // space complexity : O(n)

    // we can make this approach more optimized and can do this in 
    // time complexity : O(n^2)
    // space complexity : O(n)
    public int subarraysWithKDistinctBF(int[] nums, int k) {
        int count = 0, len = nums.length;
        for( int i = 0; i < len; i++ ){
            for ( int j = 0; j < len; j++ ){
                if ( hasKDifferentIntegers( nums, i, j+1, k)) count++;
            }
        }
        return count;
    }

    public boolean hasKDifferentIntegers( int [] nums, int lb, int ub, int k ){
        Set<Integer> set = new HashSet<>();
        for ( int i = lb; i < ub; i++ ){
            set.add(nums[i]);
        }
        return set.size() == k;
    }

    // most optimized approach
    // using atMostK - atMostk-1
    // we could used arrMap instead of HashMap, we have used hashMap for increased Readibility
    // time complexity : O(n)
    // space complexity : O(n)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKIntegers(nums, k ) - atMostKIntegers(nums, k -1);
    }
    public int atMostKIntegers(int [] nums, int k ){
        if ( k < 0 ) return 0;
        int start, end, intCount, noOfSubarrs;
        start = end = intCount = noOfSubarrs = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while ( end < len){
            int currInt = nums[end];
            map.put(currInt, map.getOrDefault(currInt, 0) + 1);
            if ( map.get(currInt) == 1) intCount++;
            if ( intCount > k ){
                while ( intCount > k ){
                    int startInt = nums[start];
                    map.put( startInt, map.get(startInt) -1 );
                    if ( map.get(startInt) == 0 ) intCount--;
                    start++;
                }
            }
            noOfSubarrs += end - start + 1;
            end++;
        }
        return noOfSubarrs;
    }
}
