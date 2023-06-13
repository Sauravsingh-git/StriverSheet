package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // brute force approach
    // double for loops
    // time complexity : O(N^2)


    // using sorting
    // use a datastructure which stores key value pairs
    // store arr[i] as key and index as its key and sort by key
    // then use 2 pointers approach
    // time complexity : O(NlogN)

    // most optimized : using HashMap
    // time complexity : O(N)
    // space complexity : O(N)
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map  = new HashMap<>();
        for ( int i = 0; i < len; i++ ){
            int rem = target - nums[i];
            if ( map.containsKey(rem )){
                return new int [] { map.get(rem), i};
            }
            map.put(nums[i], i);
        }

        return new int [] { -1, -1};
    }
}
