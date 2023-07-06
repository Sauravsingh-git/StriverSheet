package Heaps.Hard;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement {
int kthElement;
    ArrayList<Integer> arr;
    PriorityQueue<Integer> pq;
    public KthLargestElement(int k, int[] nums) {
        arr = new ArrayList<>();
        pq = new PriorityQueue<>();
        for ( int ele : nums ){
            arr.add(ele);
            pq.offer(ele);
            if ( pq.size() > k )
                pq.poll();
        }
        kthElement = k;
    }
    
    public int add(int val) {
        arr.add(val);
        pq.offer(val);
        if ( pq.size() > kthElement )
            pq.poll();
        return pq.peek();
    }
}
