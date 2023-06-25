package GreedyAlgorithm.Medium;

public class NumberOfJumpsII {
    // brute force approach
    // try all possible jumps 
    // time complexity : O(n*n^n)
    // space complexity : O(n) auxillary space
    public int jumpBF(int[] nums) {
        int len = nums.length;
        int [] jumps = {len+1};
        jumpUtil(nums, 0, 0, jumps);
        return jumps[0];
    }

    public void jumpUtil( int [] nums, int idx, int currJumps, int [] jumps){
        if ( idx >= nums.length-1){
            jumps[0] = Math.min(jumps[0], currJumps);
            return;
        }
        int allowedJumps = nums[idx];
        for ( int i = 1; i <= allowedJumps; i++ ){
            jumpUtil(nums, idx+i, currJumps+1, jumps);
        }
    }

    // greedy approach : 
    // maintain a variable maxReach, which tells you the maximum number of steps you can take in currJumps jumps
    // when you exhaust all the steps in a currReach, increase the jump counter
    // and update currReach = maxReach - idx +1
    // time complexity : O(n)
    // space complexity : O(1)
    public int jump( int [] nums ){
        int len = nums.length;
        if ( len == 1) return 0;
        int maxReach = nums[0];
        int currReach = nums[0];
        int currJumps = 1;
        int idx = 1;
        while ( maxReach < len-1){
            maxReach = Math.max(maxReach, idx+nums[idx]);
            if ( maxReach >= len-1) return currJumps+1;
            idx++;
            currReach--;
            if ( currReach == 0 ){
                currReach = maxReach - idx +1;
                currJumps++;
            }
        }
        return currJumps;
    }
}
