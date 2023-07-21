package StackAndQueues.MonotonicStackQueue;

import java.util.Stack;

public class SumOfSubarrRanges {
    // brute force approach: 
    // generate all the subarrays and find the max and min 
    // then find the difference between max and min
    // time complexity : O(n^3)
    // space complexity : O(1)

    // slightly optimized
    // while generating the subsets
    // keep track of max and min
    // time complexity : O(n^2)
    // space complexity : O(1)

    // most optimized approach : take the sum of the min elements
    // then take the sum of max elements
    // result = sum_max - sum_min
    // time complexity : O(n)
    // space complexity : O(n)
    public long subArrayRanges(int[] nums) {
        return maxSum(nums) - minSum(nums);
    }

    public long minSum( int [] nums ){
        long sum = 0;
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < len+1; i++ ){
            while ( !stack.isEmpty() && (i == len || nums[stack.peek()] >= nums[i])){
                int mid = stack.pop();
                int left = stack.isEmpty()? -1 : stack.peek();
                int right = i;
                sum += ( mid - left) * ( right - mid) * (long)nums[mid];
            }
            stack.push(i);
        }
        return sum;
    }

    public long maxSum( int [] nums ){
        long sum = 0;
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < len+1; i++ ){
            while ( !stack.isEmpty() && (i == len || nums[stack.peek()] <= nums[i])){
                int mid = stack.pop();
                int left = stack.isEmpty()? -1 : stack.peek();
                int right = i;
                sum += ( mid - left) * ( right - mid) * (long)nums[mid];
            }
            stack.push(i);
        }
        return sum;
    }
}
