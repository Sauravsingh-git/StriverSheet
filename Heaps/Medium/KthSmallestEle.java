package Heaps.Medium;

import java.util.PriorityQueue;

public class KthSmallestEle {

    // using priority Queue
    // time complexity : O(nlogk)
    // space complexity : O(k)
    public int kthSmallest(int[] arr, int l, int r, int k) { 
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y)-> y - x);
        for ( int ele : arr){
            queue.offer(ele);
            if ( queue.size() > k )
                queue.poll();
        }
        return queue.poll();
    } 


    // most optimized approach
    // using Quick select -> for kth largest
    // time complexity : O(n)
    // space complexity : O(logn)
     // using quick select
    // time complexity : O(N)
    // space complexity : O(N)

    public int findKthLargest( int [] nums, int k ){
        int len = nums.length;
        return findKthLargestUtil( nums, len-k, 0, len-1);
    }

    public int findKthLargestUtil( int [] nums, int k, int lb, int ub){
        int pivot = findPivot(nums, lb, ub);
        if ( pivot == k ) return nums[pivot];
        if ( pivot < k ) return findKthLargestUtil(nums, k, pivot + 1, ub);
        else return findKthLargestUtil( nums, k, lb, pivot - 1);
    }

    public int findPivot( int [] nums, int lb, int ub ){
        int pivotEle = nums[ub];
        int pivotIdx = lb;
        for ( int i = lb; i < ub; i++ ){
            if ( nums[i] < pivotEle){
                swap(nums, pivotIdx, i);
                pivotIdx++;
            }
        }
        swap( nums, pivotIdx, ub);
        return pivotIdx;
    }

    public void swap( int [] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
  
    // using priorityQueue
    // time complexity : O(nlogk)
    // space complexity : O(k)
    public int findKthLargestPQ(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for ( int ele : nums ){
            queue.offer(ele);
            if ( queue.size() > k) 
                queue.poll();
        }
        return queue.poll();
    }
}
