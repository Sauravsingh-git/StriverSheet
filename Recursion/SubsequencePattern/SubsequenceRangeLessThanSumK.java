package Recursion.SubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequenceRangeLessThanSumK {
    // question : You are given an array of integers nums and an integer target.
    // Return the number of non-empty subsequences of nums such that the sum of the
    // minimum and maximum element on it is less or equal to target. Since the answer
    // may be too large, return it modulo 10^9 + 7.

    private final int MODULO_7 = 1_000_000_007;
    // intuition : we do not really need to generate all the subsets
    // we can sort the elements, and apply 2 pointer algo on it
    // having pointers low, high -> low will be min and high will be max
    // if ( arr[low] + arr[high] <= target ) add 2^(high - low) to the count
    public int numSubseq( int [] nums, int target ){
        int len = nums.length;
        int count = 0;
        // precompute the powers of 2 
        int [] power = new int [len];
        power[0] = 1;
        for ( int i = 1; i < len; i++ ){
            power[i] = (power[i-1] * 2) % MODULO_7;
        }

        // sort the array
        Arrays.sort(nums);
        int low = 0, high = len -1;
        while ( low <= high ){
            if ( nums[low] + nums[high] <= target ){
                count += power[high - low];
                count %= MODULO_7;
                low++;
            }else{
                high--;
            }
        }
        return count;
    }
    // sub-optimal approach 
    // intuition : can be done by the technique used to count the total subsequnces with given sum k
    // instead of keeping sum, keep track of max and min
    public int numSubseqSO( int [] nums, int target){
        return countReqSubseqs(nums, target, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int countReqSubseqs(int [] nums, int target, int min, int max, int idx){
        if ( idx == nums.length ){
            if ( min == Integer.MAX_VALUE || min + max > target ) return 0;
            return 1;
        }

        // not including the element at the curr idx in the subsequence
        int case1 = countReqSubseqs(nums, target, min,  max, idx+1)%MODULO_7;
        // including the element at the curr idx in the subsequence
        min = Math.min(min, nums[idx]);
        max = Math.max(max, nums[idx]);
        // if ( min + max  > target ) return 0;

        int case2 = countReqSubseqs(nums, target, min, max, idx+1)%MODULO_7;
        return (case1 + case2)%MODULO_7;
    }

    // brute force approach
    // time complexity : O(2^n)
    // space complexity : O(2^n)
    public int numSubseqBF(int[] nums, int target) {
        int count = 0;
        List<List<Integer>> possibleSubsequences = generateSubsets(nums);
        possibleSubsequences.remove(0);
        for ( List<Integer> currSubsequence : possibleSubsequences ){
            int diff = calculateMinMaxDiff(currSubsequence);
            if ( diff <= target)
                count++;
            if( count > MODULO_7){
                count %= MODULO_7;
            }
        }
        return count;
    }

    public List<List<Integer>> generateSubsets(int [] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsets(int [] nums, int idx, List<Integer> currList, List<List<Integer>> subsets ){
        if ( idx == nums.length){
            subsets.add(new ArrayList<>(currList));
            return;
        }

        // ignoring the element at curr idx
        generateSubsets(nums, idx + 1, currList, subsets);
        // taking the element at curr idx
        currList.add(nums[idx]);
        generateSubsets(nums, idx +1, currList, subsets);
        currList.remove(currList.size()-1);
    }

    private int calculateMinMaxDiff(List<Integer> list ){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for ( int ele : list ){
            max = Math.max(ele, max);
            min = Math.min(ele, min);
        }
        return max + min;
    }

}
