package StackAndQueues.MonotonicStackQueue;

import java.util.Stack;

public class SumOfMinEleOfSubset {
    private final int MODULO_7 = 1000_000_007;
    // intuition we will look for the range in which a number is minimum
    // approach : we will keep track of the minEleToLeft and minEleToRight
    // instead of keeping the actual element we will keep the index of the element
    // to find the subsets in which an element will be min
    // sum += [( currIdx - leftMinEleIdx ) + ( rightMinEleIdx - currIdx) ] * currEle
    // time complexity : O(n)
    // space complexity : O(n)
    public int sumSubarrayMins( int [] arr){
        Stack<Integer> stack = new Stack<>();
        long sumOfMin = 0;
        int len = arr.length;
        for ( int i = 0; i < len + 1; i++ ){
            while ( !stack.isEmpty() && ( i == arr.length || arr[stack.peek()] >= arr[i])){
                int mid = stack.pop();
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;

                long count = ( mid - leftBoundary) * ( rightBoundary - mid ) %MODULO_7;
                sumOfMin += ( count * arr[mid])%MODULO_7;
                sumOfMin %= MODULO_7;
            }
            stack.push(i);
        }

        return ( int ) sumOfMin;
    }
    // time complexity : O(n^2)
    // space complexity : O(1)
    public int sumSubarrayMinsO( int [] arr ){
        int len = arr.length;
        int minSum = 0;
        for ( int i = 0; i < len; i++ ){
            int min = arr[i];
            for ( int j = i; j < len; j++ ){
                min = Math.min( min, arr[j]);
                minSum += min;
                minSum %= MODULO_7;
            }
        }
        return minSum;
    }
    // brute force 
    // generate all  the subarrays and find the min element in the subset
    // time complexity : O(n^3)
    // space complexity : O(1)
    public int sumSubarrayMinsBF(int[] arr) {

        int sum = 0;
        int len = arr.length;
        for ( int i = 0;  i < len; i++ ){
            for ( int j = i; j < len; j++ ){
                int minEle = findMinInSubset(arr, i, j+1);
                sum += minEle;
            }
        }
        return sum;
    }


    public int findMinInSubset( int [] arr, int lb, int ub){
        int min = Integer.MAX_VALUE;
        for ( int i = lb; i < ub; i++ ){
            min = Math.min( min, arr[i]);
        }
        return min;
    }
}
