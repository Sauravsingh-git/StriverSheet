package Arrays.Easy;
import java.util.*;
public class LongestSubarrSumK {
    // brute force approach
    // works for both arrays with only positive values as well as with negative values
    // since we are generating all the possible subarrays
    // time complexity : O(n^2)
    public static int lenOfLongSubarr1(int arr[], int len, int target) {
        int maxWindowSize = 0;
        for ( int i = 0;  i < len; i++ ){
            int sum = 0;
            for( int j = i; j < len; j++ ){
                sum += arr[j];
                if ( sum == target)
                    maxWindowSize = Math.max(maxWindowSize, j-i+1);
            }
        }
        return maxWindowSize;
    }
    
    // using sliding window approach
    // will work for POSITIVE INTEGERS ONLY
    // wont work for values with negative numbers
    // we could have a possible arr [1, 10, -1] and target = 10
    // which this approach when we move to 11 we will start removing elements from the start
    // and miss the potentially largest subarray [1, 10, -1]
    // time complexity : O(n)
    // space complexity : O(1)  
    public static int lenOfLongSubarr2 (int arr[], int len, int target) {
        int start, end, maxWindowSize, currSum;
        start = end = maxWindowSize = currSum = 0;
        
        while ( end < len){
            if( currSum <= target ){
                if ( currSum == target )
                maxWindowSize = Math.max(maxWindowSize, end - start);
                // increasing the window
                currSum += arr[end];
                end++;
            }
            // decreasing the window
            if ( currSum > target){
                while ( start <= end && currSum > target)
                    currSum -= arr[start++];
            }
        }
        return maxWindowSize;
    }

    // for NEGATIVE VALUES WITH ARRAY
    // using HashMap
    // maintain a currSum variable
    // inside the map store prefixSum of each subarray 
    // update the maxWindowSize whenever currSum == target or map.contains(currSum - target)
    public static int lenOfLongSubarr( int [] arr, int len, int target ){
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;
        int maxSubarrSize = 0;
        for ( int i = 0; i < len; i++ ){
            currSum += arr[i];
            if ( currSum == target )
                maxSubarrSize = Math.max(maxSubarrSize, i+1);
            // check if hashMap contains the subarr with value currSum - target
            if ( prefixSumMap.containsKey( currSum - target ))
                maxSubarrSize = Math.max(maxSubarrSize, i - prefixSumMap.get(currSum - target));
            if ( prefixSumMap.containsKey( currSum )) continue;
            prefixSumMap.put(currSum, i);
        }
        
        return maxSubarrSize; 
    }
}
