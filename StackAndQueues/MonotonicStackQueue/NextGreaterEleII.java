package StackAndQueues.MonotonicStackQueue;

import java.util.Stack;

public class NextGreaterEleII {
    // brute force solution
    // using double array and then checking the greaterEle for every Ele

    
    // optimized solution
    // time complexity : O(n)
    // space complexity : O(n)
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int [] result = new int [len];
        int maxEle = nums[0], maxIdx = 0;
        for ( int idx = 1; idx < len; idx++ ){
            if ( nums[idx] > maxEle){
                maxEle = nums[idx];
                maxIdx = idx;
            }
        }

        for ( int i = maxIdx; i >= 0; i-- ){
            int currEle = nums[i];
            while ( !stack.isEmpty() &&  stack.peek() <= currEle )
                stack.pop();
            
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currEle);
        }

        for ( int i = len-1; i > maxIdx; i-- ){
            int currEle = nums[i];
            while ( !stack.isEmpty() &&  stack.peek() <= currEle )
                stack.pop();
            
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currEle);
        }

        return result;
    }
}
