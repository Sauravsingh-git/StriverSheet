package Arrays.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    // Optimal approach (using sets)
    // time complexity : O(n)
    // space complexity : O(n)
    public int longestConsecutive(int[] nums) {
        if( nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for( int num : nums )
            set.add(num);
        int longestStreak = 1;
        for( int num : nums){
            // only check if num is the starting of the sequence
            if(!set.contains(num-1)){
                int currNum = num;
                int currStreak = 0;
                while(set.contains(currNum)){
                    currStreak++;
                    currNum++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }

        // sorting the array
        // time complexity : O(nlogn)
        // space complexity : O(1);
    // public int longestConsecutive( int [] nums )
        // int n = nums.length;
        // if(n== 0 || n == 1) return n;
        // Arrays.sort(nums);
        // int longestStreak = 1, currStreak = 1;
        // for( int i = 1; i < n; i++){
        //     if( nums[i] == nums[i-1]) continue;
        //     if(nums[i] == nums[i-1] + 1){
        //         currStreak++;
        //         longestStreak = Math.max(currStreak, longestStreak);
        //     }else{
        //         currStreak = 1;
        //     }
        // }
        // return longestStreak;
    //}
}
