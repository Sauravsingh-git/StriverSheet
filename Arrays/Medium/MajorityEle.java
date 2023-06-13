package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityEle {
    // brute force approach
    // time complexity : O(n)
    // space complexity : O(n)
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int ele : nums )
            map.put(ele, map.getOrDefault(ele, 0)+1);
        
        int maxOccurences = 0, ele = Integer.MAX_VALUE;
        for ( Map.Entry<Integer, Integer> entry : map.entrySet() ){
            if ( entry.getValue() > maxOccurences ) {
                maxOccurences = entry.getValue();
                ele = entry.getKey();
            }
        }
        return ele;
    }

    public int majorityElement ( int [] nums ){
        int occurences = 1;
        int eleIdx= 0;
        int len = nums.length;
        for ( int i = 1; i < len; i++ ) {
            if ( nums[eleIdx] == nums[i] ){
                occurences++;
            }else{
                occurences--;
                if ( occurences < 0 ){
                    eleIdx = i;
                    occurences = 0;
                }
            }
        }
        return nums[eleIdx];
    }
}
