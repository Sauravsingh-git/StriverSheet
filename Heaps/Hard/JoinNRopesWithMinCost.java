package Heaps.Hard;

import java.util.PriorityQueue;

public class JoinNRopesWithMinCost {
    // brute force approach: 
    // sort the list which contains the ropes
    // take two smallest ropes
    // then join the ropes and then again add them to the list
    // sort the list again 
    // repeat the above process until you have only one peice of the rope left
    // time complexity : O(n^2logn)
    // space complexity : O(1)

    
    // most optimized approach : greedy solution
    // intuition : This is similar to merging n arrays
    // time complexity : O(nlogn)
    // space complexity : O(1)
    long minCost(long arr[], int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for ( long ele : arr )
            pq.offer(ele);
        
        long currCost = 0;
        while ( pq.size() != 1 ){
            long firstSmallest = pq.poll();
            long secondSmallest = pq.poll();
            currCost += firstSmallest + secondSmallest;
            pq.offer(firstSmallest + secondSmallest);
        }
        return currCost;
    }
}
